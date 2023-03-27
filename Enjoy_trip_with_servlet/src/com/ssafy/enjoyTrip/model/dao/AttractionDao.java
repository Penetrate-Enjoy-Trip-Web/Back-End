package com.ssafy.enjoyTrip.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.enjoyTrip.dto.Attraction;

public interface AttractionDao {

	List<Attraction> selectSido() throws SQLException;

}
