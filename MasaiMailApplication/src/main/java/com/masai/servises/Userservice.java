package com.masai.servises;

import java.util.List;
import com.masai.exceptions.UserException;
import com.masai.models.User;

public interface Userservice {
	
	public User CreateUser(User user)throws UserException;
	public User UserFindById(Integer id)throws UserException;

	public List<User> allUser() throws UserException;
	User UpdateUser(User user) throws UserException;

}
