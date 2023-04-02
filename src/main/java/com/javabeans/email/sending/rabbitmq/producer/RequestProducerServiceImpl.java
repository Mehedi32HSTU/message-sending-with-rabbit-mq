package com.javabeans.email.sending.rabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javabeans.email.sending.rabbitmq.RequestDto;
import com.javabeans.email.sending.rabbitmq.RequestStatusDto;
import com.javabeans.email.sending.send_email.MailBody;

@Service
public class RequestProducerServiceImpl implements RequestProducerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@Override
	public ResponseEntity<?> publishRequest(RequestDto requestDto) {
		try {
			logger.info("<<<<<---------- publishRequest method is called ---------->>>>>");
			RequestStatusDto requestStatusDto = new RequestStatusDto();
			requestStatusDto.setRequestDto(requestDto);
			requestStatusDto.setMessage("REQUEST IS INPROGRESS");
			requestStatusDto.setStatus("INPROGRESS");

			MailBody mailBody = new MailBody();
			mailBody.setSendTo(requestDto.getSendTo());
			mailBody.setSendCCTo(requestDto.getSendToCC());
			mailBody.setMailSubject(requestDto.getSubject());
			String messageBody = "Dear Sir,\r\n"
					+ "\r\n"
					+ "The login credentials are given below,\r\n"
					+ "\r\n"
					+ "Username: "+"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"\r\n"
					+ "Password: "+"abcdefghijklmnopqrstuvwxyz"+"\r\n"
					+ "\r\n"
					+ "Thanks,\r\n"
					+ "Client Service Team\r\n"
					+ "JavaBeans";

			mailBody.setMessageBody(messageBody);

			rabbitMQSender.send(mailBody);
			return ResponseEntity.ok().body(requestStatusDto);
		} catch (Exception e) {
			return handleException(e, "publishRequest");
		}
	}

	private ResponseEntity<?> handleException(Exception e, String methodName) {
		logger.info("Exception {} has occured in {} method.", e.getMessage(), methodName);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception "+ e.getMessage() +" has occured");
	}

}
