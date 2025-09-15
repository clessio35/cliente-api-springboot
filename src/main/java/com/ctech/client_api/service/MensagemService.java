package com.ctech.client_api.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.ctech.client_api.dto.ClienteMessage;

@Service
public class MensagemService {

	private final RabbitTemplate rabbitTemplate;
	
	public MensagemService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void enviarMensagem(ClienteMessage mensagem) {
		rabbitTemplate.convertAndSend("ClienteQueue", mensagem);
	}
}
