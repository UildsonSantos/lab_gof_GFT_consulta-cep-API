package com.uildsonsantos.consultacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConsultacepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultacepApplication.class, args);
	}

}
