package com.ssafy.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.enjoyTrip.dto.Board;

public interface BoardService {
	List<Board> list() throws Exception;
	Board detail(int no) throws Exception;
	void write(Board board) throws Exception;
	void modify(Board board) throws Exception;
	void delete(int no) throws Exception;
}
