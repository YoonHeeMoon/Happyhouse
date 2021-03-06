package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MvMypage")
public class MvMypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MvMypage() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String path = "/user/mypage.jsp";
		response.sendRedirect(root + path);
	}

}
