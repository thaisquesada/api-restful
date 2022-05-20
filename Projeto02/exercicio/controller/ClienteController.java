package org.serratec.backend.java.projeto02.controller;

import java.util.List;

import org.serratec.backend.java.projeto02.entidade.Cliente;
import org.serratec.backend.java.projeto02.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/lista")
	public List<Cliente> getCliente(){
		return clienteService.listaCliente();
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<Cliente> buscar(@PathVariable Integer idCliente) {
		return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Cliente cliente) {
		clienteService.adicionar(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PostMapping("/atualizar/{posicaoLista}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer posicaoLista, @RequestBody Cliente clienteDaApi) {
		clienteService.atualizar(posicaoLista, clienteDaApi);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletar/{posicaoLista}")
	public ResponseEntity<Void> deletar(@PathVariable int posicaoLista) {
		clienteService.deletar(posicaoLista);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}