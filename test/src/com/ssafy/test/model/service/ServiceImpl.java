package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.dto.User;
import com.ssafy.test.model.dao.DaoImpl;

public class ServiceImpl {
	DaoImpl dao = DaoImpl.getInstance();
	
	private static ServiceImpl service = new ServiceImpl();
	
	public void regist(Mobile moblie) throws SQLException {
		dao.moblieInsert(moblie);
	}
	
	public static ServiceImpl getInstance() {
		return service;
	}

	public List<Mobile> getList() throws SQLException {
		return dao.allSelect();
	}

	public Mobile getMobile(String model) throws SQLException {
		return dao.Select(model);
	}

	public void delete(String mobileCode) throws SQLException {
		dao.delete(mobileCode);
		
	}

	public User login(String id, String password) throws SQLException {
		return dao.login(id,password);
	}
}
