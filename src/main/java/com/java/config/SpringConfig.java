package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.java.service.AccountService;
import com.java.service.AccountServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.java")
public class SpringConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver configureViewResolver() {
		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setPrefix("/WEB-INF/" +
				"");
		viewResolve.setSuffix(".jsp");
		return viewResolve;
	}

}
