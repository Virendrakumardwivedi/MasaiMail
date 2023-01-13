package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Email;
@Repository
public interface EmailDAO extends JpaRepository<Email, Integer>{
	
	

}
