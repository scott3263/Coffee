package com.example.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class CoffeeApplication {

	//private static Logger logger = Logger.getLogger(CoffeeApplication.class.getName());
	public static void main(String[] args) {
		//logger.info("aaa");
		SpringApplication.run(CoffeeApplication.class, args);
	}

}
