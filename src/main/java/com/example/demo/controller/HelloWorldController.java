package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.HelloBean;

@RestController
public class HelloWorldController {
	
	
	@RequestMapping(method=RequestMethod.GET,path="/hello")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping("/helloworld-bean")
	public HelloBean helloBean() {
		return new HelloBean("hello bean");
	}
	
	
	@GetMapping("/hello/{name}")
	public HelloBean helloBeanPath(@PathVariable("name")String name) {
		return new HelloBean("hello "+name);
	}
	
	

}
