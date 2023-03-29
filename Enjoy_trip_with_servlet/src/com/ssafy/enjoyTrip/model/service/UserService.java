package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.dto.User;

public interface UserService {

	User checkIdPw(User user) throws Exception;

	void register(User user) throws Exception;

}
