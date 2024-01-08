package com.workspace.userservice.services;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workspace.userservice.models.UserAccountDetails;
import com.workspace.userservice.models.UserSecrets;
import com.workspace.userservice.repositories.UserAccountRepositoryImp;

@Service
public class UserAccountServiceBAL implements UserAccountService{

	
	@Autowired 
	UserAccountRepositoryImp userAccountRepo;
	
	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException
	{
		return userAccountRepo.getByUserName(userName);
	}
}
