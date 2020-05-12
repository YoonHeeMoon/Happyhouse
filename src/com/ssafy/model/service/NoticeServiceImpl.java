package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.NoticeDao;
import com.ssafy.model.dao.NoticeDaoImpl;
import com.ssafy.model.dto.NoticeDto;

public class NoticeServiceImpl implements NoticeService{
	
	private NoticeDao noticeDao;
	
	public NoticeServiceImpl() {
		noticeDao = new NoticeDaoImpl();
	}

	@Override
	public List<NoticeDto> listNotice() throws Exception {
		return noticeDao.listNotice();
	}

	@Override
	public NoticeDto getNotice(int no) throws Exception {
		return noticeDao.getNotice(no);
	}

	@Override
	public void writeNotice(NoticeDto noticeDto) throws Exception {
		noticeDao.writeNotice(noticeDto);
		
	}

	@Override
	public void editNotice(NoticeDto noticeDto) throws Exception {
		noticeDao.editNotice(noticeDto);
		
	}

	@Override
	public void deleteNotice(int no) throws Exception {
		noticeDao.deleteNotice(no);
	}

}
