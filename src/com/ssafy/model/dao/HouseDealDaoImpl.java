package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.HouseDealDto;
import com.ssafy.util.DBUtil;

public class HouseDealDaoImpl implements HouseDealDao{

	public List<HouseDealDto> listHouse(String sel, String search) throws SQLException {
		List<HouseDealDto> list = new ArrayList<HouseDealDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append("select no, dong, AptName, dealAmount, type ");
			sql.append("from housedeal ");
			if(!search.isEmpty()) {
				if("동별".equals(sel)) {
					sql.append("where dong like ? ");
				} else {
					sql.append("where AptName like ? ");
				}
			}
			sql.append("order by no desc;");
			pstmt = conn.prepareStatement(sql.toString());
			if(!search.isEmpty()) {
				pstmt.setString(1, "%" + search + "%");
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				HouseDealDto houseDealDto = new HouseDealDto();
				houseDealDto.setNo(rs.getInt("no"));
				houseDealDto.setDong(rs.getString("dong"));
				houseDealDto.setAptName(rs.getString("AptName"));
				houseDealDto.setDealAmount(rs.getString("dealAmount"));
				String ty = rs.getString("type");
				if("1".equals(ty))
					houseDealDto.setType("아파트 매매");
				else if("2".equals(ty))
					houseDealDto.setType("아파트 전월세");
				else if("3".equals(ty))
					houseDealDto.setType("다세대 매매");
				else if("4".equals(ty))
					houseDealDto.setType("다세대 전월세");
				list.add(houseDealDto);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return list;
	}

	@Override
	public HouseDealDto viewDetail(int viewNo) throws SQLException {
		HouseDealDto detail = new HouseDealDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append("from housedeal ");
			sql.append("where no = ?;");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, viewNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				detail.setNo(rs.getInt("no"));
				detail.setDong(rs.getString("dong"));
				detail.setAptName(rs.getString("AptName"));
				detail.setCode(rs.getString("code"));
				detail.setDealAmount(rs.getString("dealAmount"));
				detail.setBuildYear(rs.getString("buildYear"));
				detail.setDealYear(rs.getString("dealYear"));
				detail.setDealMonth(rs.getString("dealMonth"));
				detail.setDealDay(rs.getString("dealDay"));
				detail.setArea(rs.getString("area"));
				detail.setFloor(rs.getString("floor"));
				detail.setJibun(rs.getString("jibun"));
				
				String typ = rs.getString("type");
				if("1".equals(typ))
					detail.setType("아파트 매매");
				else if("2".equals(typ))
					detail.setType("아파트 전월세");
				else if("3".equals(typ))
					detail.setType("다세대 매매");
				else if("4".equals(typ))
					detail.setType("다세대 전월세");
				
				if(rs.getString("rentMoney") == null)
					detail.setRentMoney("없음");
				else
					detail.setRentMoney(rs.getString("rentMoney"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return detail;
	}

}
