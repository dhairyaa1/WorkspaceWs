package com.workspace.common.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.workspace.common.models.DynamicParameter;

import jakarta.persistence.ParameterMode;

@Repository
public class DataRepository {

	
	@Autowired

	SessionFactory sessionFactory;
	
	
	public <Out> CompletableFuture<List<Out>> get(String storedProcedure,HashMap<String, DynamicParameter<?>> dp, Class<?> entityClass)
	{
		Session session = sessionFactory.openSession();
		ProcedureCall call =session.createStoredProcedureCall(storedProcedure);
		call.addSynchronizedEntityClass(entityClass);
		for(String element : dp.keySet())
		{

			call.registerParameter(element, dp.get(element).getType(), ParameterMode.IN);
			call.setParameter(element, dp.get(element).getValue());
			
		}
		
		
		return CompletableFuture.completedFuture((List<Out>)call.getResultList());
		

	}

	@Async
	public <Out> CompletableFuture<Out> getByParams(String storedProcedure,HashMap<String, DynamicParameter<?>> dp, Class<?> entityClass)
	{
		Session session = sessionFactory.openSession();
		ProcedureCall call =session.createStoredProcedureCall(storedProcedure);
		call.addSynchronizedEntityClass(entityClass);
		for(String element : dp.keySet())
		{

			call.registerParameter(element, dp.get(element).getType(), ParameterMode.IN);
			call.setParameter(element, dp.get(element).getValue());
		}
		
		
		return CompletableFuture.completedFuture((Out)call.getSingleResult());

	}
	
	@Async
	public CompletableFuture<Integer> executeStoredprocedure(String storedProcedure, HashMap<String, DynamicParameter<?>> dp)
	{
				Session session = sessionFactory.openSession();
				ProcedureCall call =session.createStoredProcedureCall(storedProcedure);
				call.addSynchronizedEntityClass(Integer.class);
					
				for(String element : dp.keySet())
				{
		
					call.registerParameter(element, dp.get(element).getType(), ParameterMode.IN);
					call.setParameter(element, dp.get(element).getValue());
				}
				
				
				return CompletableFuture.completedFuture((Integer)call.getOutputParameterValue("ResultCount"));
	}
	
	
}
