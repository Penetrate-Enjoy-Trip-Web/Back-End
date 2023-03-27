package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.ssafy.test.dto.Mobile;
import com.ssafy.test.dto.User;
import com.ssafy.test.util.DBUtil;

public class DaoImpl {
	private static DaoImpl dao = new DaoImpl();
	
	private DBUtil db;
	

	private DaoImpl() {
		db = DBUtil.getInstance();
	}

	public static DaoImpl getInstance() {
		return dao;
	}
	
	public void moblieInsert(Mobile moblie) throws SQLException {
		Connection con = db.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into (mobileCode, model, price, company) values (?,?,?,?)");
		int cnt = 0;
		pstmt.setString(++cnt, moblie.getCode());
		pstmt.setString(++cnt, moblie.getModel());
		pstmt.setInt(++cnt, moblie.getPrice());
		pstmt.setString(++cnt, moblie.getCompany());
		pstmt.executeUpdate();
	}
	public List<Mobile> allSelect() throws SQLException {
		Connection con = db.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from mobile");
		ResultSet rs = pstmt.executeQuery();
		List<Mobile>list = new ArrayList<>();
		
		while(rs.next()) {
			Mobile mobile = new Mobile();
			mobile.setCode(rs.getString("moblieCode"));
			mobile.setModel(rs.getString("model"));
			mobile.setPrice(rs.getInt("price"));
			mobile.setCompany(rs.getString("company"));
		}
		return list;
	}
	public Mobile Select(String model) throws SQLException {
		Connection con = db.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from mobile where model = "+ model);
		ResultSet rs = pstmt.executeQuery();
		Mobile mobile = new Mobile();
		if(rs.next()) {
			mobile.setCode(rs.getString("moblieCode"));
			mobile.setModel(rs.getString("model"));
			mobile.setPrice(rs.getInt("price"));
			mobile.setCompany(rs.getString("company"));
		}
		return mobile;
	}
	public void delete(String mobileCode) throws SQLException {
		Connection con = db.getConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from mobile where = ?");
		pstmt.setString(1, mobileCode);
		pstmt.executeUpdate();
		
	}
	public User login(String id, String password) throws SQLException {
		Connection con = db.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from user where id = ? and pw = ?");
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		User user = new User();
		if(rs.next()) {
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("pw"));
			return user;
		}
		return null;
	}
		
	
	
}
