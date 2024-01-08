package com.workspace.userservice.repositories;

import java.util.concurrent.ExecutionException;

import com.workspace.userservice.models.UserAccountDetails;
import com.workspace.userservice.models.UserSecrets;

public interface UserAccountRepository {
	
	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException;
}
