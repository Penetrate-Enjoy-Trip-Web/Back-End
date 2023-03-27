package com.ssafy.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.dto.User;
import com.ssafy.test.model.service.ServiceImpl;

@WebServlet("/moblie")
public class Controller extends HttpServlet{
	ServiceImpl service;
	
	@Override
	public void init() throws ServletException {
		service = ServiceImpl.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("regist")) {
			String path = regist(request, response);
			response.sendRedirect(path);
		}
		
		else if(action.equals("list")) {
			List<Mobile>list = new ArrayList<>();
			String path = "";
			try {
				list = service.getList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				path = "error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
			request.setAttribute("mobileList", list);
			path = "/listMobile.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		else if(action.equals("detail")) {
			Mobile mobile = new Mobile();
			String path = "";
			
			try {
				mobile = service.getMobile(request.getParameter("model"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				path = "/error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
			request.setAttribute("mobile", mobile);
			path = "/detailMobile.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		else if(action.equals("delete")) {
			String path = "";
			
			try {
				service.delete(request.getParameter("mobileCode"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				path = request.getContextPath() + "/error/error.jsp";
				response.sendRedirect(path);
				return;
			}
			path = request.getContextPath() + "/moblie?action=list";
			response.sendRedirect(path);
		}
		
		else if(action.equals("login")) {
			String path = "";
			User user = null;
			try {
				user = service.login(request.getParameter("id"),request.getParameter("pw"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				path = "/error/error.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
			if(user != null) {
				request.getSession().setAttribute("userInfo", user);
				if(request.getParameter("remember") == "checked")
					response.addCookie(new Cookie("saveId", user.getId()));
			}
			path = "/index.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		else if(action.equals("logout")) {
			String path = "/index.jsp";
			request.getSession().invalidate();
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	private String regist(HttpServletRequest request, HttpServletResponse response) {
		Mobile moblie = new Mobile();
		moblie.setCode(request.getParameter("code"));
		moblie.setModel(request.getParameter("model"));
		moblie.setPrice(Integer.parseInt(request.getParameter("price").trim()));
		moblie.setCompany(request.getParameter("company"));
		try {
			service.regist(moblie);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return request.getContextPath() + "/error/error.jsp";
		}
		return request.getContextPath() + "/moblie?action=list";
		
	}
}
