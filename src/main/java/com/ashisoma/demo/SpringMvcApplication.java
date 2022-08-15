package com.ashisoma.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringMvcApplication {

	// TODO: 18/10/2021 add dependancies

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
