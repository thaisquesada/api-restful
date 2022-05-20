package org.serratec.backend.java.projeto02.controller;

//end point que acessa o nosso serviço para retornar para o front

import java.util.List;

import org.serratec.backend.java.projeto02.entidade.Todo;

import org.serratec.backend.java.projeto02.service.TodoService;
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
public class TodoController {

	//podemos acessar a classe Service e usar os serviços por lá
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/lista")
	public List<Todo> getTodo(){
		return todoService.listaTodo();
	}
	
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionar(@RequestBody Todo todo) {
		todoService.adicionar(todo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar{/idTodo}")
	public ResponseEntity<Todo> buscar(@PathVariable Integer idTodo) {
		return ResponseEntity.ok(todoService.buscarPorId(idTodo));
	}
	
	@PostMapping("/atualizar/{posicaoLista}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer posicaoLista, @RequestBody Todo todoDaApi) {
		todoService.atualizar(posicaoLista, todoDaApi);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletar/{posicaoLista}")
	public ResponseEntity<Void> deletar(@PathVariable int posicaoLista) {
		todoService.deletar(posicaoLista);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}