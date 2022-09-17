package com.example.demo.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	@Query(value="select * from User_Info where email=?1 and password=?2",nativeQuery = true)
	 public User login(String email, String password);


	public User findByEmailAndPassword(String email,String password);
	
	public User findByEmail(String email);

}
