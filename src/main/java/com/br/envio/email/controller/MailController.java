package com.br.envio.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.envio.email.model.Mail;
import com.br.envio.email.service.MailService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/email")
public class MailController {

	@Autowired
	private MailService mailService;

	@PostMapping()
	public ResponseEntity<Mail> enviarEmail(@RequestBody Mail email) {
		try {
			mailService.sendEmail(email);
			log.info("Email enviado com sucesso -> " + email.getEmail());
			return new ResponseEntity<>(email, HttpStatus.OK);
		} catch (MailException e) {
			log.error("Erro ao enviar o email " + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
