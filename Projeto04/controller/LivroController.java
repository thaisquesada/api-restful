package org.serratec.backend.java.projeto04.controller;

import java.util.List;

import org.serratec.backend.java.projeto04.dto.LivroDTO;
import org.serratec.backend.java.projeto04.service.LivroService;
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
@RequestMapping("/livro")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody LivroDTO livroDTO) {
		return ResponseEntity.ok(livroService.salvar(livroDTO));
	}
	
	@GetMapping("/buscar/{idLivro}")
	public ResponseEntity<LivroDTO> buscarPorId(@PathVariable Integer idLivro) {
		return ResponseEntity.ok(livroService.buscarPorId(idLivro));
	}

	@PutMapping("/atualizar/{idLivro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idLivro, @RequestBody LivroDTO livroDTO) {
		return ResponseEntity.ok(livroService.atualizar(idLivro, livroDTO));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCartao) {
		livroService.deletar(idCartao);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<LivroDTO>> listarTodos() {
		return ResponseEntity.ok(livroService.buscarTodos());
	}

}