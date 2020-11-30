package com.br.envio.email.model;

import lombok.Data;

@Data
public class Mail {

	private String name;
	private String email;
	private String subject;
	private String message;
}
