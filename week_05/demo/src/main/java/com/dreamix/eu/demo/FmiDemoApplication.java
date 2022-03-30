package com.dreamix.eu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FmiDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FmiDemoApplication.class, args);
	}

	@Autowired
	Car carBean;

	@Autowired
	HomeRadio homeRadio;

	@Override
	public void run(String ...run) {
		carBean.listenToRadio();
		// homeRadio.listenToMusicAtHome();
	}
}
