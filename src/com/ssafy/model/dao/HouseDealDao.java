package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.HouseDealDto;

public interface HouseDealDao {
	
	public List<HouseDealDto> listHouse(String sel, String search) throws SQLException;
	
	public HouseDealDto viewDetail(int viewNo) throws SQLException;
}
