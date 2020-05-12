package com.ssafy.model.service;

import java.sql.SQLException;

import com.ssafy.model.dto.UserInfoDto;

public interface UserInfoService {
	public void join(UserInfoDto userInfoDto) throws Exception;

	public UserInfoDto login(String loginid, String loginpwd) throws Exception;

	public void editUserInfo(UserInfoDto userInfoDto) throws Exception;

	public boolean pwCheck(String pw) throws Exception;

	public void deleteUserInfo(String userid) throws Exception;
}
