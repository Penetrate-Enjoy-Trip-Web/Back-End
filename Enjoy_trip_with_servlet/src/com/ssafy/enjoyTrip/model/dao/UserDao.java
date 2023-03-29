package com.ssafy.enjoyTrip.model.dao;

import java.sql.SQLException;

import com.ssafy.enjoyTrip.dto.User;

public interface UserDao {

	User selectIdPw(User user) throws SQLException;

	void insertUser(User user) throws SQLException;

	User selectId(String id) throws SQLException;

	void deleteUser(String id) throws SQLException;

}
