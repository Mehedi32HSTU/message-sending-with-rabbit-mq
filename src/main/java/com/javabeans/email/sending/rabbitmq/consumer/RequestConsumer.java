package com.javabeans.email.sending.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabeans.email.sending.send_email.EmailService;
import com.javabeans.email.sending.send_email.MailBody;

@Component
public class RequestConsumer {
	
	@Autowired
	private EmailService emailService;

	@RabbitListener(queues = "${spring.rabbitmq.queuename}")
	public void requestConsumer(MailBody mailBody) {
		System.out.println("From requestConsumer, "+mailBody.toString());

		emailService.sendEmail(mailBody.getSendTo(), mailBody.getSendCCTo(), mailBody.getMailSubject(), mailBody.getMessageBody());
	}

	@RabbitListener(queues = "${com.javabeans.deadLetterQueue}")
	public void dlqRequestConsumer(String requestString) {
		System.out.println("From dlqRequestConsumer, "+requestString);
	}
}
