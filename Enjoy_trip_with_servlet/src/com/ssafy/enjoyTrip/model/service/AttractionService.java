package com.ssafy.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.enjoyTrip.dto.Attraction;

public interface AttractionService {

	List<Attraction> getSidoList() throws Exception;

	List<Attraction> getAttractionList(Attraction attraction) throws Exception;

}
