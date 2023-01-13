package com.masai.servises;

import com.masai.DTO.UserLoginDTO;
import com.masai.exceptions.LoginException;
import com.masai.models.CurrentUserSession;

public interface UserLoginService {
	
	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto)throws LoginException;

	public String logOutFromUserAccount(String key)throws LoginException;

}
