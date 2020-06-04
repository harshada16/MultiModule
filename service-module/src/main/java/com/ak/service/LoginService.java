package com.ak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.dao.LoginDao;

@Service
public class LoginService {
	@Autowired
	LoginDao loginDao;
	
	public void loginCheck()
	{
		loginDao.loginCheck();
		System.out.println("login service>>logincheck");
	}
}
