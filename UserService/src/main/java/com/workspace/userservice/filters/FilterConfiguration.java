package com.workspace.userservice.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.workspace.common.Filters.AuthenticationFilter;

import jakarta.servlet.Filter;

@Configuration
public class FilterConfiguration {

	
	@Autowired
	@Bean
	public FilterRegistrationBean<Filter> getFilterRegistration(AuthenticationFilter authFilter)
	{
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(authFilter);		
		return filterRegistrationBean;
	}
}
