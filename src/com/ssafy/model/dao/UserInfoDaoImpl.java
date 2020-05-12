package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.model.dto.UserInfoDto;
import com.ssafy.util.DBUtil;

public class UserInfoDaoImpl implements UserInfoDao{

	@Override
	public void join(UserInfoDto userInfoDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into user (userid, username, userpwd, tel, email) \n");
			sql.append("values (?, ?, ?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userInfoDto.getUserid());
			pstmt.setString(2, userInfoDto.getUsername());
			pstmt.setString(3, userInfoDto.getUserpwd());
			pstmt.setString(4, userInfoDto.getTel());
			pstmt.setString(5, userInfoDto.getEmail());
			pstmt.executeUpdate();
			
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

	@Override
	public UserInfoDto login(String loginid, String loginpwd) throws SQLException {
		UserInfoDto userInfoDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select userid, userpwd, username, email, tel \n");
			sql.append("from user \n");
			sql.append("where userid = ? and userpwd = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, loginid);
			pstmt.setString(2, loginpwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userInfoDto = new UserInfoDto();
				userInfoDto.setUserid(rs.getString("userid"));
				userInfoDto.setUsername(rs.getString("username"));
				userInfoDto.setUserpwd(rs.getString("userpwd"));
				userInfoDto.setEmail(rs.getNString("email"));
				userInfoDto.setTel(rs.getNString("tel"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return userInfoDto;
	}

	@Override
	public void editUserInfo(UserInfoDto userInfoDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update user \n");
			sql.append("set username = ?, userpwd = ?, tel = ?, email = ? \n");
			sql.append("where userid = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userInfoDto.getUsername());
			pstmt.setString(2, userInfoDto.getUserpwd());
			pstmt.setString(3, userInfoDto.getTel());
			pstmt.setString(4, userInfoDto.getEmail());
			pstmt.setString(5, userInfoDto.getUserid());
			pstmt.executeUpdate();
			
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteUserInfo(String userid) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from user \n");
			sql.append("where userid = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}
}
