package com.masai.DTO;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class UserLoginDTO {

	@NotNull(message = "Mobile number should not be null")
	private String mobileNumber;
	
	@NotNull(message="password should not be null")
	private String password;
}
