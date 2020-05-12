package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.NoticeDto;
import com.ssafy.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao{

	@Override
	public List<NoticeDto> listNotice() throws SQLException {
		List<NoticeDto> list = new ArrayList<NoticeDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select no, author, title, writedate\n");
			sql.append("from notice\n");
			sql.append("order by no desc;");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeDto noticeDto = new NoticeDto();
				noticeDto.setNo(rs.getInt("no"));
				noticeDto.setAuthor(rs.getString("author"));
				noticeDto.setTitle(rs.getString("title"));
				noticeDto.setWritedate(rs.getString("writedate"));
				list.add(noticeDto);
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return list;
	}

	@Override
	public NoticeDto getNotice(int no) throws Exception {
		NoticeDto noticeDto = new NoticeDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("select no, author, title, content, writedate\n");
			sql.append("from notice\n");
			sql.append("where no = ?;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				noticeDto.setNo(rs.getInt("no"));
				noticeDto.setAuthor(rs.getString("author"));
				noticeDto.setTitle(rs.getString("title"));
				noticeDto.setContent(rs.getString("content"));
				noticeDto.setWritedate(rs.getString("writedate"));
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		return noticeDto;
	}

	@Override
	public void writeNotice(NoticeDto noticeDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into notice (author, title, content) \n");
			sql.append("values (?, ?, ?)");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, noticeDto.getAuthor());
			pstmt.setString(2, noticeDto.getTitle());
			pstmt.setString(3, noticeDto.getContent());
			pstmt.executeUpdate();
			
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void editNotice(NoticeDto noticeDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update notice \n");
			sql.append("set title = ?, content = ? \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContent());
			pstmt.setInt(3, noticeDto.getNo());
			pstmt.executeUpdate();
			
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteNotice(int no) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from notice \n");
			sql.append("where no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

}
