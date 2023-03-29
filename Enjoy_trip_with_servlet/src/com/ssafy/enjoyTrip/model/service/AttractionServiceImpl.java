package com.ssafy.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.enjoyTrip.dto.Attraction;
import com.ssafy.enjoyTrip.model.dao.AttractionDao;
import com.ssafy.enjoyTrip.model.dao.AttractionDaoImpl;

public class AttractionServiceImpl implements AttractionService {
	
	private AttractionDao attractionDao = AttractionDaoImpl.getInstance();
	
	private static AttractionService instance = new AttractionServiceImpl();
	private AttractionServiceImpl() {}
	public static AttractionService getInstance() {
		return instance;
	}
	@Override
	public List<Attraction> getSidoList() throws Exception {
		return attractionDao.selectSido();
	}
	@Override
	public List<Attraction> getAttractionList(Attraction attraction) throws Exception {
		return attractionDao.selectAttractionBySearch(attraction);
	}
}
