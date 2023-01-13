package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.CurrentUserSession;

@Repository
public interface UserSessionDao extends JpaRepository<CurrentUserSession, String>{
	
    public CurrentUserSession findByUuid(String uuid);
	public CurrentUserSession findByEmail(String email);

}
