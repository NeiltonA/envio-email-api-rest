package com.br.envio.email.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	@Value("${ENDERECO_HOST}")
	protected String host;
	
	@Value("${PORT_HOST}")
	protected Integer port;
	
	@Value("${ENDERECO_USERNAME}")
	protected String username;
	
	@Value("${PASSWORD_USER}")
	protected String password;
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.host);
		mailSender.setPort(this.port);

		mailSender.setUsername(this.username);
		mailSender.setPassword(this.password);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}
}
