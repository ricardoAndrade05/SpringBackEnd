package com.nelioalves.coursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.nelioalves.coursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
	
	
}
