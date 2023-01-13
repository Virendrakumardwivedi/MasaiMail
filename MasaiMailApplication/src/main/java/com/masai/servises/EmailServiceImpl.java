package com.masai.servises;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.EmailDAO;
import com.masai.exceptions.EmailException;
import com.masai.exceptions.UserException;
import com.masai.models.Email;
import com.masai.models.User;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private EmailDAO ED;
	
	

	@Override
	public Email createEmail(Email emil) throws EmailException {
		// TODO Auto-generated method stub
		return ED.save(emil);
	}

	@Override
	public Email createEmailById(Integer id) throws EmailException, UserException {

		Optional<Email> opt = ED.findById(id);
		if(opt.isPresent()) {
			Email email = new Email();
		  return ED.save(email);
		}else {
			throw new UserException("user not exist in this id "+id);
		}
	
	}

	@Override
	public String deleteEmail(Integer userId) throws UserException {
		String message= " User not found";
		Optional<Email> opt = ED.findById(userId);
		
		if(opt.isPresent()) {
			Email email = opt.get();
			ED.delete(email);
			message = "deleted";
			
		}else {
			throw new UserException("user not exixt");
		}
		return message;
	}


	
}
