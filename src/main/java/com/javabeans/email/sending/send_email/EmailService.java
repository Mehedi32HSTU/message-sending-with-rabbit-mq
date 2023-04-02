package com.javabeans.email.sending.send_email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String sendTo, String sendToCC,String mailSubject, String messageBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendTo);
        message.setCc(sendToCC);
        message.setSubject(mailSubject);
        message.setText(messageBody);

        mailSender.send(message);
    }

	public void sendEmail(String[] sendTo, String[] sendToCC, String mailSubject, String messageBody) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(sendTo);
		message.setCc(sendToCC);
		message.setSubject(mailSubject);
		message.setText(messageBody);
		
		mailSender.send(message);
	}
	
}
