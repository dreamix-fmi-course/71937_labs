package com.fmi.web.theaterticketsystem;

import com.fmi.web.theaterticketsystem.model.Event;
import com.fmi.web.theaterticketsystem.service.EventService;
import com.fmi.web.theaterticketsystem.service.TicketService;
import com.fmi.web.theaterticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties
public class TheaterticketsystemApplication {
	private final EventService eventService;
	private final UserService userService;
	private final TicketService ticketService;


	public static void main(String[] args) {
		SpringApplication.run(TheaterticketsystemApplication.class, args);
	}

	@Autowired
	public TheaterticketsystemApplication(final EventService eventService, final UserService userService, final TicketService ticketService) {
		this.eventService = eventService;
		this.userService = userService;
		this.ticketService = ticketService;
	}
}
