package com.masai.servises;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.UserLoginDTO;
import com.masai.Repo.UserDAO;
import com.masai.Repo.UserSessionDao;
import com.masai.exceptions.LoginException;
import com.masai.models.CurrentUserSession;
import com.masai.models.User;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceIMPL implements UserLoginService{
	
	@Autowired
	private UserSessionDao userSessionDao;
	@Autowired
	private UserDAO userDao;
	
	
	
	@Override
	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto) throws LoginException {
		User existingUser = userDao.findByMobilenumber(dto.getMobileNumber());
		
				if (existingUser == null)
					throw new LoginException("Please Enter a valid mobile number");
		
				CurrentUserSession validUserSessionOpt = userSessionDao.findByEmail(existingUser.getMobilenumber());
		
				if (validUserSessionOpt!=null) {
					throw new LoginException("User already Logged In with this number");
				}
		
				if (existingUser.getPassword().equals(dto.getPassword())) {
					String key = RandomString.make(6);
					CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getMobilenumber(), key,
							LocalDateTime.now());
					userSessionDao.save(currentUserSession);
					return currentUserSession;
				} else
					throw new LoginException("Please Enter a valid password!");
	}
	@Override
	public String logOutFromUserAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}
	


}
