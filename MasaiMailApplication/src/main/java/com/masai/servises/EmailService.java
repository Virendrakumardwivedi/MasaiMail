package com.masai.servises;


import com.masai.exceptions.EmailException;
import com.masai.exceptions.UserException;
import com.masai.models.Email;

public interface EmailService {

	public Email createEmail(Email emil) throws EmailException;
	public Email createEmailById(Integer id)throws EmailException, UserException; 
	public String deleteEmail(Integer userId) throws UserException;

}
