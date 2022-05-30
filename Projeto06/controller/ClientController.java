package org.serratec.backend.projeto06.controller;

import java.util.List;

import org.serratec.backend.projeto06.dto.ClientDTO;
import org.serratec.backend.projeto06.exception.ClientException;
import org.serratec.backend.projeto06.service.ClientService;
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

@RestController
@RequestMapping
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody ClientDTO clientDTO) {
		return ResponseEntity.ok(clientService.save(clientDTO));
	}
	
	@GetMapping("/search/{clientId}")
	public ResponseEntity<ClientDTO> searchById(@PathVariable Integer clientId) throws ClientException {
		return ResponseEntity.ok(clientService.searchById(clientId));
	}
	
	@PutMapping("/update/{clientId}")
	public ResponseEntity<String> update(@PathVariable Integer clientId, @RequestBody ClientDTO clientDTO) throws ClientException {
		return ResponseEntity.ok(clientService.update(clientId, clientDTO));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@PathVariable Integer clientId) {
		clientService.delete(clientId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ClientDTO>> findAll() {
		return ResponseEntity.ok(clientService.findAll());
	}
	
}