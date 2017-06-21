package com.hm.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class EventosSocialesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventosSocialesApiApplication.class, args);
	}
}
