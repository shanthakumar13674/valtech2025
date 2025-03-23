package com.valtech.training.registerservice.services;

import com.valtech.training.registerservice.vos.UserVO;

public interface UserService {

	UserVO addUserToSubscription(UserVO vo, long sub);

	UserVO getUser(long id);

	UserVO signIn(UserVO vo);

	void deleteUserFromSubscription(long userId);

}