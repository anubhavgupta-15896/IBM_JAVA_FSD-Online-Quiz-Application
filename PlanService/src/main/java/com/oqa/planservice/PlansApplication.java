package com.oqa.planservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {""})
public class PlansApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlansApplication.class, args);
	}
}
