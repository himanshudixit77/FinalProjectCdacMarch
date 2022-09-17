package com.example.demo.UserService;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserRepository.UserRepository;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;

@Service
public class UserService  {

	@Autowired
	private UserRepository urepo;
	
	
	public User addUser(UserDto user) {
		
	  User u=urepo.findByEmail(user.getEmail());
	  if(u==null)
	  {
		  User userInfo=new User();
		  Address address=new Address();
		  userInfo.setUserName(user.getUserName());
		  userInfo.setRegisdate(new Date());
		  userInfo.setPassword(user.getPassword());
		  userInfo.setImagePath(user.getImagePath());
		  userInfo.setEmail(user.getEmail());
		  address.setCity(user.getCity());
		  address.setCountry(user.getCountry());
		  address.setPincode(user.getPincode());
		  address.setState(user.getState());
		  address.setStreetNo(user.getStreetNo());
		  address.setUser(userInfo);
		  userInfo.setAddress(address);
		 return urepo.save(userInfo);
	  }
	return null;
	 
	}

	public User login(String email, String password) {
		
		 User us=urepo.login(email,password);
		 if(us!=null)
			 return us;
		 else
			 return null;}
	
	public User findById(int userId) {
		// TODO Auto-generated method stub
		 return urepo.findById(userId).get();
	}

	
 

}
