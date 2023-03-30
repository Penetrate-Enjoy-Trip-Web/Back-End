package com.ssafy.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoyTrip.dto.Board;
import com.ssafy.enjoyTrip.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private DBUtil db = DBUtil.getInstance();
	
	private static BoardDao instance = new BoardDaoImpl();
	private BoardDaoImpl() {}
	public static BoardDao getInstance() {
		return instance;
	}
	@Override
	public List<Board> selectAll() throws SQLException {
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select no, title, content, writer, createDate, modifyDate, viewCount from board order by no desc");
		) {
			ResultSet rs = pstmt.executeQuery();
			List<Board> list = new ArrayList<>();
			while(rs.next()){
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriter(rs.getString("writer"));
				b.setCreateDate(rs.getString("createDate"));
				b.setModifyDate(rs.getString("modifyDate"));
				b.setViewCount(rs.getInt("viewCount"));
				list.add(b);
			}
			return list;
		}
	}
	@Override
	public Board selectByNo(int no) throws SQLException {
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select no, title, content, writer, createDate, modifyDate, viewCount"
					+ " from board" 
					+ " where no = ?");
		) {
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriter(rs.getString("writer"));
				b.setCreateDate(rs.getString("createDate"));
				b.setModifyDate(rs.getString("modifyDate"));
				b.setViewCount(rs.getInt("viewCount"));
				return b;
			}
			return null;
		}
	}
	
	@Override
	public int insert(Board board) throws SQLException {
		int result = 0;
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into board(title, content, writer)"
					+ " values(?, ?, ?)");
		) {
			int idx = 0;
			pstmt.setString(++idx, board.getTitle());
			pstmt.setString(++idx, board.getContent());
			pstmt.setString(++idx, board.getWriter());
			result = pstmt.executeUpdate();
		}
		return result;
	}
	
	@Override
	public void updateByNo(Board board) throws SQLException {
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("update board"
					+ " set title = ?, content = ?, modifyDate = ?"
					+ " where no = ?");
		) {
			int idx = 0;
			pstmt.setString(++idx, board.getTitle());
			pstmt.setString(++idx, board.getContent());
			pstmt.setString(++idx, board.getModifyDate());
			pstmt.setInt(++idx, board.getNo());
			pstmt.executeUpdate();
		}
	}
	@Override
	public void delete(int no) throws SQLException {
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from board"
					+ " where no = ?");
		) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
}
