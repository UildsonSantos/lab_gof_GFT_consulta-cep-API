package com.uildsonsantos.consultacep.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.uildsonsantos.consultacep.model.Cliente;
import com.uildsonsantos.consultacep.services.AbstractEmailService;

@Service
public class MockEmailService extends AbstractEmailService {

	@Value("${default.name}")
	private String name;
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(Cliente cliente) {
		LOG.info("Simulando envio de email...");
		LOG.info("from: " +name +" :.:.: -> to: " +cliente.getEmail() +" name:" +cliente.getNome());
		LOG.info("Email enviado");		
	}
}