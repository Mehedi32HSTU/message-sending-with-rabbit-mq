package com.javabeans.email.sending.rabbitmq.producer;

import org.springframework.http.ResponseEntity;

import com.javabeans.email.sending.rabbitmq.RequestDto;

public interface RequestProducerService {
	public ResponseEntity<?> publishRequest(RequestDto requestDto);

}
