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

@WebServlet("/write")
public class WriteNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private NoticeService noticeService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		noticeService = new NoticeServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/MvNotice";
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setTitle(request.getParameter("title"));
		noticeDto.setContent(request.getParameter("content"));
		noticeDto.setAuthor(request.getParameter("author"));
		try {
			noticeService.writeNotice(noticeDto);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "공지글을 작성 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
