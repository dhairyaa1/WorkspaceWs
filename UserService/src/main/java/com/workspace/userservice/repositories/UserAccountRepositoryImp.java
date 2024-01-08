package com.workspace.userservice.repositories;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import com.workspace.common.models.DynamicParameter;
import com.workspace.common.repositories.DataRepository;
import com.workspace.userservice.models.UserAccountDetails;
import com.workspace.userservice.models.UserSecrets;
import com.workspace.userservice.shared.StoredProcedureNames;
import org.springframework.stereotype.Repository;

@Repository

public class UserAccountRepositoryImp extends DataRepository implements UserAccountRepository
{
	public UserAccountDetails getByUserName(String userName) throws InterruptedException, ExecutionException
	{
		return super.<UserAccountDetails>getByParams(StoredProcedureNames.uspGetUserAccountDetails, new HashMap<String, DynamicParameter<?>>(), getClass()).get();
	}
}

