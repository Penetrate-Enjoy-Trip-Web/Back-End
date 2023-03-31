package com.ssafy.enjoyTrip.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.enjoyTrip.dto.User;
import com.ssafy.enjoyTrip.model.service.UserService;
import com.ssafy.enjoyTrip.model.service.UserServiceImpl;

@WebServlet("/user")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String root;
	private static HttpSession session;
	
	private UserService userService = UserServiceImpl.getInstance();
	
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
			response.sendRedirect(root + "/main/main.jsp");
		}
		
		System.out.println(action);
		switch(action) {
		case "loginForm": // 로그인 폼
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			break;
		case "login": // 로그인 Select 확인
			response.sendRedirect(root + checkIdPw(request, response));
			break;
		case "registerForm": // 회원가입 폼
			request.getRequestDispatcher("/user/register.jsp").forward(request, response);
			break;
		case "register": // 회원 Insert
			response.sendRedirect(root + register(request, response));
			break;
		case "logout": // 로그아웃. 세션 invalidate();
			session.invalidate();
			response.sendRedirect(root + "/main/main.jsp");
			break;
		case "findForm": // 회원 찾기
			request.getRequestDispatcher("/user/find.jsp").forward(request, response);
			break;
		case "find":
			request.getRequestDispatcher(find(request,response)).forward(request, response);
			break;
		case "mypage":
			request.getRequestDispatcher(myPage(request,response)).forward(request, response);
			break;
		case "deluser":
			response.sendRedirect(root + delUser(request,response));
			break;
		case "modifyForm":
			request.getRequestDispatcher(modifyForm(request,response)).forward(request, response);
			break;
		case "modify":
			request.getRequestDispatcher(modify(request,response)).forward(request, response);
			break;
			
		}
	}

	private String modifyForm(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = userService.find(request.getParameter("userId"));
			request.setAttribute("user",user);
		} catch (Exception e) {
			e.printStackTrace();
			error(request,response);
			return "/user/modify.jsp";
		}
		return "/user/modify.jsp";
	}

	private void error(HttpServletRequest request, HttpServletResponse response) {
	    // alert 메시지를 출력하는 JavaScript 코드를 작성합니다.

	    // HTTP 응답의 MIME 타입을 설정합니다.
	    response.setContentType("text/html");
	    
	    // alert 메시지를 출력하는 JavaScript 코드를 클라이언트에게 전송합니다.
	    PrintWriter out;
	    try {
	        out = response.getWriter();
	        out.print("<script>alert('Your input is wrong...'); location.href='" + request.getContextPath()+ "/user/login.jsp'</script>");
	        out.flush();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
	
		try {
			userService.modifyUser(user);
			user = userService.checkIdPw(user);
			request.setAttribute("user", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//자바스크립트 호출 함수
			error(request,response);
			return "/user/login.jsp";
		}
		return "/user/mypage.jsp";
	}

	private String delUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			userService.delUser(request.getParameter("id"));
			session.invalidate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error(request,response);
			return "/main/main.jsp";
		}
		return "/main/main.jsp";
	}

	private String myPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = userService.find(request.getParameter("userId"));
			request.setAttribute("user",user);
		} catch (Exception e) {
			e.printStackTrace();
			error(request,response);
			return "/user/mypage.jsp";
		}
		return "/user/mypage.jsp";
	}



	private String find(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = userService.find(request.getParameter("id"));
			String pw = user.getPw();
			if(pw != null) {
				request.setAttribute("pw", pw);
			}
			else {
				request.setAttribute("pw","아이디가 없습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error(request,response);
			return "/user/find.jsp";
		}
		return "/user/find.jsp";
	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 후에는 자동으로 로그인 창을 띄운다. -> /user?action=login
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		try {
			userService.register(user);
			return "/user?action=loginForm";
		} catch (Exception e) {
			e.printStackTrace();
			error(request,response);
		}
		error(request,response);
		return "/user?action=loginForm";
	}

	private String checkIdPw(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		user.setId(request.getParameter("id"));
		user.setPw(request.getParameter("pw"));
		try {
			user = userService.checkIdPw(user);
			if (user != null) {
				session = request.getSession();
				session.setAttribute("user", user);
				Cookie id = new Cookie("id", user.getId());
				response.addCookie(id);
			} 
			else {
				error(request,response);
				return "/user/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			error(request,response);
			return "/user/login.jsp";
		}
		return "/main/main.jsp";
	}


}
