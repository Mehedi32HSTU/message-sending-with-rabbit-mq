package com.javabeans.email.sending.send_email;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Value("${com.javabeans.mail.username}")
	private String username;

	@Value("${com.javabeans.password}")
	private String password;

	@Value("${com.javabeans.mail.host}")
	private String mailSerderHost;

	@Value("${com.javabeans.mail.port}")
	private int mailSerderPort;

	@Value("${com.javabeans.mail.transport.protocol}")
	private String transportProtocol;

	@Value("${com.javabeans.mail.smtp.auth}")
	private String smtpAuth;

	@Value("${com.javabeans.mail.smtp.starttls.enable}")
	private String startTls;

	@Value("${com.javabeans.mail.debug}")
	private String mailDebug;

	@Bean
	public JavaMailSender getJavaMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(mailSerderHost);
		mailSender.setPort(mailSerderPort);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		Properties properties = mailSender.getJavaMailProperties();
		properties.put("mail.transport.protocol", transportProtocol);
	    properties.put("mail.smtp.auth", smtpAuth);
	    properties.put("mail.smtp.starttls.enable", startTls);
	    properties.put("mail.debug", mailDebug);

		return mailSender;
	}

}
