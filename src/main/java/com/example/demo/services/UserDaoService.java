package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.bean.User;

@Service
public class UserDaoService {
	
	
	private static List<User>users=new ArrayList<User>();
	
	private static int userCount=2;
	
	
	static {
		
		users.add(new User(1,"malik",new Date()));
		users.add(new User(2,"gyldan",new Date()));
		
	}
	
	
	public List<User>getUsers(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId()==null) {
			user.setId(userCount++);
		}
		
		users.add(user);
		return user;
		
		
	}
	
	
	public User findOne(int id) {
		
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	
	public User deleteUserById(int id) {
		
		Iterator<User>it=users.iterator();
		while(it.hasNext()) {
			User user=it.next();
			if(user.getId()==id) {
				it.remove();
				
				return user;
			}
		}
		return null;
	}

}
