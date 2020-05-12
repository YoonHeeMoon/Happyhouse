package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.NoticeDto;
import com.ssafy.model.service.NoticeService;
import com.ssafy.model.service.NoticeServiceImpl;

@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		noticeService = new NoticeServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/notice/notice.jsp";
		int no = Integer.parseInt(request.getParameter("no"));
		
		try {
			NoticeDto noticeDto = new NoticeDto();
			noticeDto = noticeService.getNotice(no);
			request.setAttribute("notice", noticeDto);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "공지글을 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
