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
		try(
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from sido");
		) {
			ResultSet rs = pstmt.executeQuery();
			List <Attraction> list = new ArrayList<>();
			while(rs.next()) {
				Attraction attrac = new Attraction();
				attrac.setSidoCode(rs.getString("sido_code"));
				attrac.setSidoName(rs.getString("sido_name"));
				list.add(attrac);
			}
			return list;
		}
	}
	
	@Override
	public List<Attraction> selectAttractionBySearch(Attraction attraction) throws SQLException {
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						" SELECT A.content_id, A.overview, " 
								+ " B.content_type_id, B.title, B.addr1, B.zipcode, " 
								+ " B.first_image, B.first_image2, B.sido_code, B.latitude, B.longitude "
								+ " FROM attraction_description A, attraction_info B"
								+ " WHERE A.content_id = B.content_id"
								+ " AND B.sido_code LIKE ?"
								+ " AND B.content_type_id LIKE ?"
								+ " AND B.title LIKE ?"
								+ " ORDER BY B.title"
								+ " limit 0, 50");
		) {
			String sidoCode = attraction.getSidoCode();
			String contentTypeId = attraction.getContentTypeId();
			String title = attraction.getTitle();
			
			int idx = 0;
			pstmt.setString(++idx, "%" + sidoCode + "%");
			pstmt.setString(++idx, "%" + contentTypeId + "%");
			pstmt.setString(++idx, "%" + title + "%");
			ResultSet rs = pstmt.executeQuery();
			
			List <Attraction> attractionList = new ArrayList<>();
			while(rs.next()) {
				Attraction a = new Attraction();
				a.setContentId(rs.getString("content_id"));
				a.setOverview(rs.getString("overview"));
				a.setContentTypeId(rs.getString("content_type_id"));
				a.setTitle(rs.getString("title"));
				a.setAddr1(rs.getString("addr1"));
				a.setZipcode(rs.getString("zipcode"));
				a.setFirstImage(rs.getString("first_image"));
				a.setFirstImage2(rs.getString("first_image2"));
				a.setSidoCode(rs.getString("sido_code"));
				a.setLatitude(rs.getString("latitude"));
				a.setLongitude(rs.getString("longitude"));
				attractionList.add(a);
			}
			return attractionList;
		}
		
	}
}
