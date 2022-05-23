package org.serratec.backend.projeto03.controller;

import java.util.List;

import org.serratec.backend.projeto03.entity.Conta;
import org.serratec.backend.projeto03.service.ContaService;
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
@RequestMapping("/conta")
public class ContaController {

		@Autowired
		ContaService contaService;
		
		@PostMapping("/salvar")
		public ResponseEntity<Void> salvar(@RequestBody Conta conta){
			contaService.salvar(conta);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		
		@GetMapping("/buscar/{idConta}")
		public ResponseEntity<Conta> buscarPorId(@PathVariable Integer idConta) {
			return ResponseEntity.ok(contaService.buscarPorId(idConta));
		}
		
		@PutMapping("/atualizar/{idConta}")
		public ResponseEntity<Void> atualizar(@PathVariable Integer idConta, @RequestBody Conta conta) {
			contaService.atualizar(idConta, conta);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		@DeleteMapping("/deletar/{posicaoLista}")
		public ResponseEntity<Void> deletar(@PathVariable int posicaoLista) {
			contaService.deletar(posicaoLista);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/lista")
		public ResponseEntity<List<Conta>> listaTodos(){
			return ResponseEntity.ok(contaService.listartodos());
		}
		
		@PostMapping("/salvar-lista")
	    public ResponseEntity<Void> salvarLista(@RequestBody List<Conta> listaConta) {
	        contaService.salvarTodos(listaConta);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }
		
}