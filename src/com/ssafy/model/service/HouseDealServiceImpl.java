package com.ssafy.model.service;

import java.util.Collections;
import java.util.List;

import com.ssafy.model.dao.HouseDealDao;
import com.ssafy.model.dao.HouseDealDaoImpl;
import com.ssafy.model.dto.HouseDealDto;

public class HouseDealServiceImpl implements HouseDealService {

	private HouseDealDao houseDealDao;

	public HouseDealServiceImpl() {
		houseDealDao = new HouseDealDaoImpl();
	}

	@Override
	public List<HouseDealDto> listHouse(String sel, String search) throws Exception {
		sel = sel == null ? "" : sel;
		search = search == null ? "" : search;
		return houseDealDao.listHouse(sel, search);
	}

	@Override
	public HouseDealDto viewDetail(int viewNo) throws Exception {
		return houseDealDao.viewDetail(viewNo);
	}

	public List<HouseDealDto> sortList(List<HouseDealDto> list) throws Exception {
		Collections.sort(list);
		return list;
	}

}
