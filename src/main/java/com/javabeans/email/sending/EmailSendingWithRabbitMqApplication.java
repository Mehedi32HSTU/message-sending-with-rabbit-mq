package com.javabeans.email.sending;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSendingWithRabbitMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSendingWithRabbitMqApplication.class, args);
	}

}
