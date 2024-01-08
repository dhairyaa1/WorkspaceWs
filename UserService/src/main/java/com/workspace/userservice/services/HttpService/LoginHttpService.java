package com.workspace.userservice.services.HttpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workspace.common.services.HttpService;
import com.workspace.userservice.shared.ApplicationConfig;



@Service
public class LoginHttpService extends HttpService {

		
	@Autowired
	public LoginHttpService(ApplicationConfig applicationConfig)
	{
		
		super(applicationConfig.getLoginServiceUrl());
	}
	

	
}
