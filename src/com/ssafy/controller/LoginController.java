package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.UserInfoDto;
import com.ssafy.model.service.UserInfoService;
import com.ssafy.model.service.UserInfoServiceImpl;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService;
	
	@Override
	public void init() throws ServletException {
		userInfoService = new UserInfoServiceImpl();
		super.init();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = "/main.jsp";
		String loginid = request.getParameter("loginid");
		String loginpwd = request.getParameter("loginpwd");
		
		try {
			UserInfoDto userInfoDto = userInfoService.login(loginid, loginpwd);
			
			if(userInfoDto != null) {
//				session 설정
				HttpSession session = request.getSession();
				session.setAttribute("userinfo", userInfoDto);
				
//				cookie 설정
				String idsave = request.getParameter("idsave");
				if("saveok".equals(idsave)) {//아이디 저장을 체크 했다면.
					Cookie cookie = new Cookie("ssafy_id", loginid);
					cookie.setPath(request.getContextPath());
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
					response.addCookie(cookie);
				} else {//아이디 저장을 해제 했다면.
					Cookie cookies[] = request.getCookies();
					if(cookies != null) {
						for(Cookie cookie : cookies) {
							if("ssafy_id".equals(cookie.getName())) {
								cookie.setMaxAge(0);
								response.addCookie(cookie);
								break;
							}
						}
					}
				}
			}
			else {
					request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
				}
				
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
