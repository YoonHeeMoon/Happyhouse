package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;
import com.ssafy.model.dto.HouseDealDto;
import com.ssafy.model.service.HouseDealService;
import com.ssafy.model.service.HouseDealServiceImpl;

@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HouseDealService houseDealService;

	@Override
	public void init() throws ServletException {
		super.init();
		houseDealService = new HouseDealServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = "/main.jsp";
		String sel = request.getParameter("sel1");
		String search = request.getParameter("search");
		String sort = request.getParameter("sort");

		try {
			List<HouseDealDto> list = houseDealService.listHouse(sel, search);
			
			if (!StringUtils.isNullOrEmpty(sort)) {
				list = houseDealService.sortList(list);
			}
			
			request.setAttribute("houseList", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "거래 목록을 얻어오는 중 문제가 발생했습니다.");
			path = "/error/error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);

	}

}
