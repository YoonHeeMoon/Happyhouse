package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.UserInfoDto;
import com.ssafy.model.service.HouseDealServiceImpl;
import com.ssafy.model.service.UserInfoService;
import com.ssafy.model.service.UserInfoServiceImpl;

@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService;

	@Override
	public void init() throws ServletException {
		userInfoService = new UserInfoServiceImpl();
		super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = "/main.jsp";
		String userPw = request.getParameter("userpwd");
		try {
			if (!userInfoService.pwCheck(userPw)) {
				request.setAttribute("msg", "비밀번호에 특수문자가 포함되어야 합니다.");
				path = "/error/error.jsp";
			}
			else {
				UserInfoDto userInfoDto = new UserInfoDto();
				userInfoDto.setUsername(request.getParameter("username"));
				userInfoDto.setUserid(request.getParameter("userid"));
				userInfoDto.setUserpwd(request.getParameter("userpwd"));
				userInfoDto.setTel(request.getParameter("tel"));
				userInfoDto.setEmail(request.getParameter("email"));
				userInfoService.join(userInfoDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원가입 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
