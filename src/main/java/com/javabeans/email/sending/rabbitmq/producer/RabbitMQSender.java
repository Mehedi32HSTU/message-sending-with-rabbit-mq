package com.javabeans.email.sending.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.javabeans.email.sending.rabbitmq.RequestDto;
import com.javabeans.email.sending.send_email.MailBody;

@Component
public class RabbitMQSender {

	@Value("${spring.rabbitmq.exchange}")
	String exchangeName;

	@Value("${spring.rabbitmq.routingkey}")
	String routingKey;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(MailBody mailBody) {
		try {
			rabbitTemplate.convertAndSend(exchangeName, routingKey, mailBody);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
