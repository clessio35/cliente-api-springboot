package com.ctech.client_api.consumer;

import org.springframework.stereotype.Component;

import com.ctech.client_api.dto.ClienteMessage;

@Component
public class ClienteConsumer {

	public void receberMensagem(ClienteMessage mensagem) {
		System.out.println("📥 Mensagem recebida do RabbitMQ:");
        System.out.println("➡️  Ação: " + mensagem.getAction());
        System.out.println("➡️  Cliente ID: " + mensagem.getClienteId());
        System.out.println("➡️  Nome: " + mensagem.getNome());
        System.out.println("➡️  Email: " + mensagem.getEmail());
        System.out.println("➡️  Timestamp: " + mensagem.getTimestamp());
	}
}
