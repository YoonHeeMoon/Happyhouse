package com.ssafy.model.dao;

import java.sql.SQLException;

import com.ssafy.model.dto.UserInfoDto;

public interface UserInfoDao {
	public void join(UserInfoDto userInfoDto) throws SQLException;
	
	public UserInfoDto login(String loginid, String loginpwd) throws SQLException;
	
	public void editUserInfo(UserInfoDto userInfoDto) throws SQLException;
	
	public void deleteUserInfo(String userid) throws SQLException;
}
