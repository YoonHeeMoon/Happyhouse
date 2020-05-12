package com.ssafy.model.service;

import com.ssafy.model.dao.UserInfoDao;
import com.ssafy.model.dao.UserInfoDaoImpl;
import com.ssafy.model.dto.UserInfoDto;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao userInfoDao;

	public UserInfoServiceImpl() {
		userInfoDao = new UserInfoDaoImpl();
	}

	@Override
	public void join(UserInfoDto userInfoDto) throws Exception {
		userInfoDao.join(userInfoDto);
	}

	public boolean pwCheck(String pw) throws Exception {
		String ex = "!@#$%^&*()";
		for (char c : pw.toCharArray()) {
			int a = ex.indexOf(c);
			if (a != -1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public UserInfoDto login(String loginid, String loginpwd) throws Exception {
		return userInfoDao.login(loginid, loginpwd);
	}

	@Override
	public void editUserInfo(UserInfoDto userInfoDto) throws Exception {
		userInfoDao.editUserInfo(userInfoDto);

	}

	@Override
	public void deleteUserInfo(String userid) throws Exception {
		userInfoDao.deleteUserInfo(userid);
	}

}
