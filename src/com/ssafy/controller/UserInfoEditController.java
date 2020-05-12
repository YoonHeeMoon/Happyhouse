package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.UserInfoDto;
import com.ssafy.model.service.UserInfoService;
import com.ssafy.model.service.UserInfoServiceImpl;

@WebServlet("/edituserinfo")
public class UserInfoEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService;

    @Override
	public void init(ServletConfig config) throws ServletException {
    	userInfoService = new UserInfoServiceImpl();
		super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = "/main.jsp";
		
		UserInfoDto userInfoDto = new UserInfoDto();
		userInfoDto.setUsername(request.getParameter("username"));
		userInfoDto.setUserid(request.getParameter("userid"));
		userInfoDto.setUserpwd(request.getParameter("userpwd"));
		userInfoDto.setTel(request.getParameter("tel"));
		userInfoDto.setEmail(request.getParameter("email"));
		
		try {
			userInfoService.editUserInfo(userInfoDto);
			HttpSession session = request.getSession();
			session.removeAttribute("userinfo");
			session.setAttribute("userinfo", userInfoDto);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원정보 수정 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
