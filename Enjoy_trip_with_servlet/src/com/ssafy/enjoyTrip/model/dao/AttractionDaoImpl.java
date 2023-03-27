package com.ssafy.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.enjoyTrip.dto.Attraction;
import com.ssafy.enjoyTrip.util.DBUtil;

public class AttractionDaoImpl implements AttractionDao {

	private DBUtil db = DBUtil.getInstance();
	
	private static AttractionDao instance = new AttractionDaoImpl();
	private AttractionDaoImpl() {}
	public static AttractionDao getInstance() {
		return instance;
	}
	@Override
	public List<Attraction> selectSido() throws SQLException {
		Connection con = db.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from sido");
		
		ResultSet rs = pstmt.executeQuery();
		List <Attraction> list = new ArrayList<>();
		while(rs.next()) {
			Attraction attrac = new Attraction();
			attrac.setSido_code(rs.getString("sido_code"));
			attrac.setSido_name(rs.getString("sido_name"));
			list.add(attrac);
		}
		return list;
	}
}
