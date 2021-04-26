package com.corso.progetto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.corso.spring.checkstring")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/img1/**").addResourceLocations("/WEB-INF/views/Gioco/img1/");
		registry.addResourceHandler("/sound/**").addResourceLocations("/WEB-INF/views/Gioco/sound/");
		registry.addResourceHandler("/img2/**").addResourceLocations("/WEB-INF/views/Gioco/img2/");
		registry.addResourceHandler("/img3/**").addResourceLocations("/WEB-INF/views/Gioco/img3/");
		registry.addResourceHandler("/smallLife.jpg").addResourceLocations("/WEB-INF/views/Gioco/smallLife.jpg");
		registry.addResourceHandler("/style.css").addResourceLocations("/WEB-INF/views/Gioco/style.css");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/views/Gioco/js/");
	}

	
}
