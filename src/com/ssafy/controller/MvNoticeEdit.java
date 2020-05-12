package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.NoticeDto;

@WebServlet("/MvNoticeEdit")
public class MvNoticeEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MvNoticeEdit() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String path = "/notice/editnotice.jsp";
    	NoticeDto noticeDto = new NoticeDto();
    	noticeDto.setNo(Integer.parseInt(request.getParameter("no")));
    	noticeDto.setAuthor(request.getParameter("author"));
    	noticeDto.setTitle(request.getParameter("title"));
    	noticeDto.setContent(request.getParameter("content"));
    	noticeDto.setWritedate(request.getParameter("writedate"));
    	request.setAttribute("notice", noticeDto);
    	request.getRequestDispatcher(path).forward(request, response);
    }

}
