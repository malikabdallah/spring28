package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.services.UserDaoService;
import com.example.demo.bean.User;
import com.example.demo.exceptions.UserNotFoundException;
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDaoService userService;
	
	@GetMapping()
	public List<User>getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	public User userById(@PathVariable("id")String id) throws UserNotFoundException {
		

		User user=userService.findOne(Integer.valueOf(id));
		if(user==null) {
			throw new UserNotFoundException("utilisateur non trouve");
		}
		return userService.findOne(Integer.valueOf(id));
	}
	
	
	@PostMapping()
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		
		userService.saveUser(user);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") int id) throws UserNotFoundException{
		User user=userService.deleteUserById(id);
		if(user==null) {
			throw new UserNotFoundException("utilisateur non trouve");
		}
		
		return ResponseEntity.noContent().build();

		
	}
}
