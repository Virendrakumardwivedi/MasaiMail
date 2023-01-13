package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.User;
@Repository
public interface UserDAO extends JpaRepository<User,Integer>{
   
     public User findByEmail_id(String email_id);
	
	public User findByMobilenumber(String mobilenumber);
	
	
	
}
