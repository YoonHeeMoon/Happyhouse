package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.HouseDealDto;
import com.ssafy.model.service.HouseDealService;
import com.ssafy.model.service.HouseDealServiceImpl;


@WebServlet("/viewdetail")
public class ViewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HouseDealService houseDealService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		houseDealService = new HouseDealServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/viewdetail.jsp";
		int viewNo = Integer.parseInt(request.getParameter("no"));
		
		try {
			HouseDealDto viewdetail = houseDealService.viewDetail(viewNo);
			request.setAttribute("detail", viewdetail);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mas", "상세 정보를 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
