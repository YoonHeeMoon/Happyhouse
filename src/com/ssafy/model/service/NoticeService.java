package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.NoticeDto;


public interface NoticeService {
	public List<NoticeDto> listNotice() throws Exception;
	
	public NoticeDto getNotice(int no) throws Exception;
	
	public void writeNotice(NoticeDto noticeDto) throws Exception;
	
	public void editNotice(NoticeDto noticeDto) throws Exception;
	
	public void deleteNotice(int no) throws Exception;
}
