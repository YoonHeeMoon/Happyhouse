package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.HouseDealDto;

public interface HouseDealService {
	public List<HouseDealDto> listHouse(String sel, String search) throws Exception;
	public List<HouseDealDto> sortList(List<HouseDealDto> list) throws Exception;
	public HouseDealDto viewDetail(int viewNo) throws Exception;
}
