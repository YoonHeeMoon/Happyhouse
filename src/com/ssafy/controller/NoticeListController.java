package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.NoticeDto;
import com.ssafy.model.service.HouseDealServiceImpl;
import com.ssafy.model.service.NoticeService;
import com.ssafy.model.service.NoticeServiceImpl;

@WebServlet("/MvNotice")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		noticeService = new NoticeServiceImpl();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/notice/list.jsp";
		
		try {
			List<NoticeDto> list = noticeService.listNotice();
			request.setAttribute("noticeList", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "공지 목록을 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
