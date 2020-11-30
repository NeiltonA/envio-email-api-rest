package com.br.envio.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.br.envio.email.model.Mail;

@Service
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;

	}

	public void sendEmail(Mail usermodel) throws MailException {

		StringBuilder sb = new StringBuilder();
		sb.append("Name: ").append(usermodel.getName()).append(System.lineSeparator());
		sb.append("\n Message: ").append(usermodel.getMessage());

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setCc(usermodel.getEmail());//destinatario
		mail.setFrom(usermodel.getEmail());//remetente
		mail.setSubject(usermodel.getSubject());
		mail.setText(usermodel.getMessage());

		javaMailSender.send(mail);
	}
}
