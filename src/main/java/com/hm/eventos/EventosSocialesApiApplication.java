package com.hm.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableScheduling
public class EventosSocialesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventosSocialesApiApplication.class, args);
	}
}
