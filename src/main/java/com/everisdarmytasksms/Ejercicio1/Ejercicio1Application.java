package com.everisdarmytasksms.Ejercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.controller.package1, com.controller.package2, com.controller.package3, com.controller.packageN", "controller", "service" })
public class Ejercicio1Application  {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1Application .class, args);
	}

}
