package com.workspace.userservice.services;

import java.util.concurrent.ExecutionException;

import com.workspace.userservice.models.UserAccountDetails;
import com.workspace.userservice.models.UserSecrets;

public interface UserAccountService {
	public UserAccountDetails getByUserName(String userName)  throws InterruptedException, ExecutionException;
}
