package com.upekaVenture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@ComponentScan(basePackages = "com.upekaVenture")
@SpringBootApplication
@EnableScheduling
public class TelegrambotApplication {

              
	public static void main(String[] args) {
//	SpringApplication.run(TelegrambotApplication.class, args);
		  SpringApplication springApplication=new SpringApplication(TelegrambotApplication.class);
	  System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
      springApplication.run(args);
      
      Controller c = new Controller() ;
      c.getData();

	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}


}
