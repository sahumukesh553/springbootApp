package com.mukeshsoft.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController{
	
	@RequestMapping("/error")
	public String errorHandle()
	{return "no mapping found for given url";
		
	}
	
	
	

}
