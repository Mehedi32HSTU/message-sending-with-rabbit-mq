package com.javabeans.email.sending.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

	@Value("${spring.rabbitmq.host}")
	String host;

	@Value("${spring.rabbitmq.username}")
	String username;

	@Value("${spring.rabbitmq.password}")
	String password;

	@Value("${spring.rabbitmq.exchange}")
	String exchangeName;

	@Value("${spring.rabbitmq.queuename}")
	String queueName;

	@Value("${spring.rabbitmq.routingkey}")
	String routingKey;

	@Value("${com.javabeans.deadLetterQueue}")
	String deadLetterQueue;

	@Value("${com.javabeans.deadLetterExchange}")
	String deadLetterExchange;

	@Value("${com.javabeans.deadLetterRoutingkey}")
	String deadLetterRoutingkey;

	@Bean
	public Queue queue() {
		return QueueBuilder.durable(queueName).withArgument("x-dead-letter-exchange", deadLetterExchange)
				.withArgument("x-dead-letter-routing-key", deadLetterRoutingkey).build();
	}

	@Bean
	public Queue deadLetterQueue() {
		return QueueBuilder.durable(deadLetterQueue).build();
	}

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(exchangeName);
	}

	@Bean
	DirectExchange deadLetterExchange() {
		return new DirectExchange(deadLetterExchange);
	}

	@Bean
	Binding DLQbinding() {
		return BindingBuilder.bind(deadLetterQueue()).to(deadLetterExchange()).with(deadLetterRoutingkey);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
	}

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	public AmqpTemplate template(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}
}
