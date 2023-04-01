package com.javabeans.email.sending.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javabeans.email.sending.rabbitmq.RequestDto;

@Component
public class RequestConsumer {

	@RabbitListener(queues = "${spring.rabbitmq.queuename}")
	public void requestConsumer(RequestDto requestDto) {
		System.out.println(requestDto.toString());
	}

	@RabbitListener(queues = "${com.javabeans.deadLetterQueue}")
	public void dlqRequestConsumer(String requestString) {
		System.out.println(requestString);
	}
}
