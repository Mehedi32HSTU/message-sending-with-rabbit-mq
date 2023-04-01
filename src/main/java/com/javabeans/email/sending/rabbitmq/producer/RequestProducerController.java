package com.javabeans.email.sending.rabbitmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabeans.email.sending.rabbitmq.RequestDto;

@RestController
@RequestMapping
public class RequestProducerController {

	@Autowired
	private RequestProducerService requestProducerService;

	@RequestMapping(value = "/send-request", method = RequestMethod.POST)
	public ResponseEntity<?> publishRequest(@RequestBody RequestDto requestDto) {
		return requestProducerService.publishRequest(requestDto);
	}

}
