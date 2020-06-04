package com.ak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ak.service.LoginService;

@RequestMapping("api")
@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("loginCheck")
	public void loginCheck()
	{
		loginService.loginCheck();
		System.out.println("login controller>>logincheck");
	}

}
