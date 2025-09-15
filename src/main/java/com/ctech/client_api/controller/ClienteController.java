package com.ctech.client_api.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctech.client_api.dto.ClienteMessage;
import com.ctech.client_api.model.Cliente;
import com.ctech.client_api.service.ClienteService;
import com.ctech.client_api.service.MensagemService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MensagemService mensagemService;

	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteService.findById(id);
		return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		Cliente newClient = clienteService.save(cliente);
		
		ClienteMessage msg = new ClienteMessage("CREATE", newClient.getId(), newClient.getNome(), newClient.getEmail(), LocalDateTime.now());
		mensagemService.enviarMensagem(msg);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
		Optional<Cliente> cliente = clienteService.findById(id);
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		clienteService.delete(id);
		ClienteMessage msg = new ClienteMessage("DELETE", id, cliente.get().getNome(), cliente.get().getEmail(), LocalDateTime.now());
		mensagemService.enviarMensagem(msg);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
		Optional<Cliente> existente = clienteService.findById(id);
		if(existente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		Cliente clienteUpdate = clienteService.save(cliente);
		
		ClienteMessage msg = new ClienteMessage("UPDATE", clienteUpdate.getId(), clienteUpdate.getNome(), clienteUpdate.getEmail(), LocalDateTime.now());
		mensagemService.enviarMensagem(msg);
		
		return ResponseEntity.ok(clienteUpdate);
	}

}
