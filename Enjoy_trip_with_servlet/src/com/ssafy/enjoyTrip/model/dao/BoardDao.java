package com.ssafy.enjoyTrip.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.enjoyTrip.dto.Board;

public interface BoardDao {
	List<Board> selectAll() throws SQLException;
	Board selectByNo(int no) throws SQLException;
	int insert(Board board) throws SQLException;
	void updateByNo(Board board) throws SQLException;
	void delete(int no) throws SQLException;
}
