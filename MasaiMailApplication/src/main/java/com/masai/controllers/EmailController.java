package com.masai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.exceptions.EmailException;
import com.masai.exceptions.UserException;
import com.masai.models.Email;
import com.masai.servises.EmailService;

@Controller
@RequestMapping("/masaimail")
public class EmailController {
	
	@Autowired
	private EmailService ES;
	
	
	@PostMapping("/register")
	public ResponseEntity<Email> registerUswers(@RequestBody Email email)throws EmailException{
		Email addemail = ES.createEmail(email);
		
		return new ResponseEntity<Email>(addemail,HttpStatus.OK);
		
	}

	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) throws EmailException, UserException{
		String email = ES.deleteEmail(id);
		
		return new ResponseEntity<String>(email,HttpStatus.OK);
	}
	

}
