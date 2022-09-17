package com.example.demo.Controller;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UserService.UserService;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserService userv;
	
	/*@PostMapping("/add")
	public User addUser(@Valid @RequestBody User user) {
	
	user.setRegisdate(new Date());
	return userv.addUser(user);

}*/
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody UserDto user){
		try {
		User user2=userv.addUser(user);
		return ResponseEntity.ok(user2);
		}catch (Exception e) {
		
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@PostMapping("/login")
	public User login(@RequestBody LoginDto lDto) {
		 return userv.login(lDto.getEmail(), lDto.getPassword());
	}
/*@requestbody user , 
 * 2-String email string password,
 * 3-@requestbody logindto * will work*/
 
}
