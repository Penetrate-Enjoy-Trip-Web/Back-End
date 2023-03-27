package com.ssafy.enjoyTrip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationContext;

import com.ssafy.enjoyTrip.dto.Attraction;
import com.ssafy.enjoyTrip.model.service.AttractionService;
import com.ssafy.enjoyTrip.model.service.AttractionServiceImpl;

@WebServlet("/attraction")
public class AttractionController extends HttpServlet{

	private AttractionService attractionService = AttractionServiceImpl.getInstance();
	
	private static String root;
	private static List<Attraction> list;
	private static ServletContext application;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (application == null) {
			application = request.getServletContext();
			try {
				list = attractionService.getList();
				application.setAttribute("sidoList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String action = request.getParameter("action");
		root = request.getContextPath();
		if (action == null || action.equals("")) {
			response.sendRedirect(root + "/main.jsp");
		}
		
		switch(action) {
		case "trip":
			request.getRequestDispatcher("/trip/trip.jsp").forward(request, response);
			break;
		}
		
		
	}
	
}
