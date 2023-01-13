package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.DTO.UserLoginDTO;
import com.masai.exceptions.LoginException;
import com.masai.exceptions.UserException;
import com.masai.models.CurrentUserSession;
import com.masai.models.User;
import com.masai.servises.UserLoginService;
import com.masai.servises.Userservice;

@Controller
@RequestMapping("/masaimail")
public class UserControllers {

	
	@Autowired
	private UserLoginService userLogin;
	
	@Autowired
	private Userservice US;
	
	@PostMapping("/login/user")
	public ResponseEntity<CurrentUserSession> logInUser(@Valid @RequestBody UserLoginDTO dto) throws LoginException {
		
		CurrentUserSession result = userLogin.logIntoUserAccount(dto);
		
		return new ResponseEntity<CurrentUserSession>(result,HttpStatus.ACCEPTED );
		
	}
	
	
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUswers(@RequestBody User user)throws UserException{
		User addUseres = US.CreateUser(user);
		
		return new ResponseEntity<User>(addUseres,HttpStatus.CREATED);
		
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id")Integer id)throws UserException{
		User user = US.UserFindById(id);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllRoutes() throws UserException{
		
		List<User> routes = US.allUser();
		
		return new ResponseEntity<List<User>>(routes,HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateFeedback(@Valid @RequestBody User user,@RequestParam(required = false) String key) throws  UserException {
		
		User user1 = US.UpdateUser(user);
		
		return new ResponseEntity<User>(user1,HttpStatus.ACCEPTED);
		
	}

	
	
}
