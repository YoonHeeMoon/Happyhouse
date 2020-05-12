package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.NoticeDto;

public interface NoticeDao {
	public List<NoticeDto> listNotice() throws SQLException;
	
	public NoticeDto getNotice(int no) throws Exception;
	
	public void writeNotice(NoticeDto noticeDto) throws SQLException;
	
	public void editNotice(NoticeDto noticeDto) throws SQLException;
	
	public void deleteNotice(int no) throws SQLException;
}
