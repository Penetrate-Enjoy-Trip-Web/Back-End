package com.ssafy.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.enjoyTrip.dto.User;
import com.ssafy.enjoyTrip.util.DBUtil;

public class UserDaoImpl implements UserDao{

	private DBUtil db = DBUtil.getInstance();
	
	private static UserDao instance = new UserDaoImpl();
	private UserDaoImpl() {}
	public static UserDao getInstance() {
		return instance;
	}
	
	@Override
	public User selectIdPw(User user) throws SQLException {
		try (
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select id, pw, name, email from user where id = ? and pw = ?");
		) {
			int idx = 0;
			pstmt.setString(++idx, user.getId());
			pstmt.setString(++idx, user.getPw());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		}
		return null;
	}
	@Override
	public void insertUser(User user) throws SQLException {
		try (
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into user(id, pw, name, email) values (?, ?, ?, ?)");
		) {
			int idx = 0;
			pstmt.setString(++idx, user.getId());
			pstmt.setString(++idx, user.getPw());
			pstmt.setString(++idx, user.getName());
			pstmt.setString(++idx, user.getEmail());
			pstmt.executeUpdate();
		}
		
	}
	@Override
	public User selectId(String id) throws SQLException {
		try (
			Connection con = db.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from user where id = ?");
		){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			User user = new User();
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				return user;
			}
			else return null;
		}
		
	}
	@Override
	public void deleteUser(String id) throws SQLException {
		try(
				Connection con = db.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from user where id = ?");
		){
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
	}
	@Override
	public void updateUser(User user) throws SQLException {
		try(
		Connection con = db.getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"update user set pw=?, name=?, email=? where id = ?");
		){
			int cnt = 0;
			pstmt.setString(++cnt, user.getPw());
			pstmt.setString(++cnt, user.getName());
			pstmt.setString(++cnt, user.getEmail());
			pstmt.setString(++cnt, user.getId());
			
			pstmt.executeUpdate();
		}
			
		
	}
}
