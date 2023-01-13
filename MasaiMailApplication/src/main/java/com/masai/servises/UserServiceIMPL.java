package com.masai.servises;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.UserDAO;
import com.masai.exceptions.UserException;
import com.masai.models.User;

@Service
public class UserServiceIMPL  implements Userservice{
	
	@Autowired
	private UserDAO UD;
	

	@Override
	public User CreateUser(User user) throws UserException {
		return UD.save(user);
	}

	@Override
	public User UserFindById(Integer id) throws UserException {
		Optional<User> opt = UD.findById(id);
		if(opt.isPresent()) {
			User user = opt.get();
			return user;
		}else {
			throw new UserException("user not exist in this id "+id);
		}
	}

	@Override
	public User UpdateUser(User user) throws UserException {
	Optional<User> opt = UD.findById(user.getEmail_id());


		if (opt.isPresent()) {
			User userUpdate= UD.save(user);

			return userUpdate;
		}
		

		throw new UserException("user detail Error.");
	}

	@Override
	public List<User> allUser() throws UserException {
		List<User> list = UD.findAll();
		if(list.size()==0) {
			throw new UserException("user is not present..!");
			
		}
		return list;
	}

}
