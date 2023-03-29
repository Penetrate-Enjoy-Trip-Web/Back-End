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
}
