package com.ssafy.enjoyTrip.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.enjoyTrip.dto.Board;
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
		if (action == null || action.equals("")) action = "list";
		
		switch (action) {
		case "list":
			// forward
			request.getRequestDispatcher(list(request, response)).forward(request, response);
			break;
		case "detail":
			// forward
			request.getRequestDispatcher(detail(request, response)).forward(request, response);
			break;
		case "writeForm":
			// foward
			request.getRequestDispatcher("/board/write.jsp").forward(request, response);
			break;
		case "write":
			// 작성후 -> redirect list
			response.sendRedirect(root + write(request, response));
			break;
		case "modifyForm":
			// forward
			int no = Integer.parseInt(request.getParameter("no"));
			try {
				request.setAttribute("board", boardService.detail(no));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/board/write.jsp").forward(request, response);
			break;
		case "modify":
			// 수정 후 -> redirect detail
			response.sendRedirect(root + modify(request, response));
			break;
		case "delete":
			// 삭제 후 -> redirect list - servlet
			response.sendRedirect(root + delete(request, response));			
			break;
		}
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		try {
			boardService.delete(no);
			return "/board?action=list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/error/error.jsp";
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		Board board = new Board();
		System.out.println(request.getParameter("no"));
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));

		// 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 포맷 적용
        String modifyDate = now.format(formatter);
        // 결과 입력
		board.setModifyDate(modifyDate);

		try {
			boardService.modify(board);
			return "/board?action=detail&no=" + board.getNo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/error/error.jsp";
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		Board board = new Board();
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		try {
			boardService.write(board);
			return "/board?action=list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/error/error.jsp";
	}

	private String detail(HttpServletRequest request, HttpServletResponse response) {
		int no = Integer.parseInt(request.getParameter("no"));
		try {
			request.setAttribute("board", boardService.detail(no));
			return "/board/detail.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/error/error.jsp";
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("boards", boardService.list());
			return "/board/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/error/error.jsp";
	}
}
