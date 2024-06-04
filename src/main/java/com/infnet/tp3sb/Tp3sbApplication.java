package com.infnet.tp3sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Tp3sbApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp3sbApplication.class, args);
	}

}
