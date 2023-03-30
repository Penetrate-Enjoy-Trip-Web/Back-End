package com.ssafy.enjoyTrip.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.enjoyTrip.model.service.BoardService;
import com.ssafy.enjoyTrip.model.service.BoardServiceImpl;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	
	private BoardService boardService = BoardServiceImpl.getInstance();
	private static String root;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		root = request.getContextPath();
		if (action == null || action.equals("")) {
			response.sendRedirect(root + "/main.jsp");
		}
		
		switch (action) {
		case "list":
			
			break;
		case "detail":
			
			break;
		case "writeForm":
			
			break;
		case "write":
			
			break;
		case "modifyForm":
			
			break;
		case "modify":
			
			break;
		case "delete":
			
			break;
		}
	}
}
