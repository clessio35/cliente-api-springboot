package com.ctech.client_api.dto;

import java.time.LocalDateTime;

public class ClienteMessage {

	private String action;
	private Long clienteId;
	private String nome;
	private String email;
	private LocalDateTime timestamp;

	public ClienteMessage() {
	}

	public ClienteMessage(String action, Long clienteId, String nome, String email, LocalDateTime timestamp) {
		this.action = action;
		this.clienteId = clienteId;
		this.nome = nome;
		this.email = email;
		this.timestamp = timestamp;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
}
