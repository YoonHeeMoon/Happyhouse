package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.service.UserInfoService;
import com.ssafy.model.service.UserInfoServiceImpl;

@WebServlet("/deleteuserinfo")
public class UserInfoDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService;

	public void init(ServletConfig config) throws ServletException {
    	userInfoService = new UserInfoServiceImpl();
		super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = "/main.jsp";
		String userid = request.getParameter("userid");
		try {
			userInfoService.deleteUserInfo(userid);
			HttpSession session = request.getSession();
			session.removeAttribute("userinfo");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 삭제 처리 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
