package com.ctech.client_api.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctech.client_api.dto.ClienteMessage;

@Service
public class MensagemService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void enviarMensagem(ClienteMessage mensagem) {
		System.out.println("Send message for RabbitMQ: " + mensagem);
		rabbitTemplate.convertAndSend("clienteQueue", mensagem);
	}
}
