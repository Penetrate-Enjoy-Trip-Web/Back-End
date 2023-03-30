package com.ssafy.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.enjoyTrip.dto.Board;
import com.ssafy.enjoyTrip.model.dao.BoardDao;
import com.ssafy.enjoyTrip.model.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = BoardDaoImpl.getInstance();
	
	private static BoardService instance = new BoardServiceImpl();
	private BoardServiceImpl() {}
	public static BoardService getInstance() {
		return instance;
	}
	@Override
	public List<Board> list() throws Exception {
		return boardDao.selectAll();
	}
	@Override
	public Board detail(int no) throws Exception {
		boardDao.viewCountUp(no);
		return boardDao.selectByNo(no);
	}
	@Override
	public void write(Board board) throws Exception {
		int result = boardDao.insert(board);
		if (result == 0) {
			System.out.println("입력 실패");
		}
	}
	@Override
	public void modify(Board board) throws Exception {
		boardDao.updateByNo(board);
	}
	@Override
	public void delete(int no) throws Exception {
		boardDao.delete(no);
	}

}
