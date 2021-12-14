package com.medplus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.medplus"})
public class Config {
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver rvr =new InternalResourceViewResolver();
		rvr.setSuffix(".jsp");
		rvr.setPrefix("/WEB-INF/");
		return rvr;
		
	}
}
