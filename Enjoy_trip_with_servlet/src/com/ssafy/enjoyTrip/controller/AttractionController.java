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

import com.google.gson.Gson;
import com.ssafy.enjoyTrip.dto.Attraction;
import com.ssafy.enjoyTrip.model.service.AttractionService;
import com.ssafy.enjoyTrip.model.service.AttractionServiceImpl;

@WebServlet("/attraction")
public class AttractionController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private static AttractionService attractionService = AttractionServiceImpl.getInstance();
	
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
				list = attractionService.getSidoList();
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
		case "attraction":
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(getAttractionList(request, response));
			break;		
		case "main":
			request.getRequestDispatcher("/main/main.jsp").forward(request, response);
			break;
		}
	}

	private static String getAttractionList(HttpServletRequest request, HttpServletResponse response) {
		String sidoCode = request.getParameter("areaCode");
		String contentTypeId = request.getParameter("contentTypeId");
		String title = request.getParameter("keyword");
		
		if(sidoCode == null) sidoCode = "";
		if(contentTypeId == null) contentTypeId = "";
		if(title == null) title = "";
		
		Attraction attraction = new Attraction();
		attraction.setSidoCode(sidoCode);
		attraction.setContentTypeId(contentTypeId);
		attraction.setTitle(title);
		
		
		
//		StringBuffer result = new StringBuffer();
//		result.append("{\"result\":[");
//			List<Attraction> attractionList = attractionService.getAttractionList(attraction);
//			for (Attraction attrac : attractionList) {
//				result.append("[{\"value\": \"" + attrac.getContentId() + "\"},");
//				result.append("{\"value\": \"" + attrac.getOverview() + "\"},");
//				result.append("{\"value\": \"" + attrac.getContentTypeId() + "\"},");
//				result.append("{\"value\": \"" + attrac.getTitle() + "\"},");
//				result.append("{\"value\": \"" + attrac.getAddr1() + "\"},");
//				result.append("{\"value\": \"" + attrac.getZipcode() + "\"},");
//				result.append("{\"value\": \"" + attrac.getFirstImage() + "\"},");
//				result.append("{\"value\": \"" + attrac.getFirstImage2() + "\"},");
//				result.append("{\"value\": \"" + attrac.getSidoCode() + "\"},");
//				result.append("{\"value\": \"" + attrac.getLatitude() + "\"},");
//				result.append("{\"value\": \"" + attrac.getLongitude() + "\"}],");
//			}
//			result.append("]}");
			try {
				return new Gson().toJson(attractionService.getAttractionList(attraction));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "{\"error\": \"error\"}";
			}
	}
}
