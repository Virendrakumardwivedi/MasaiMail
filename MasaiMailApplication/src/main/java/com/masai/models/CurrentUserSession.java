package com.masai.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSession {	
	@Id
	@Column(unique = true)
	private String email;	
	private String uuid;	
	private LocalDateTime dateTime;	
}
