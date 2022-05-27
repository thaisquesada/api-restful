package org.serratec.backend.java.projeto04.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.java.projeto04.dto.LivroDTO;
import org.serratec.backend.java.projeto04.entity.Livro;
import org.serratec.backend.java.projeto04.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	// CREATE
	public String salvar(LivroDTO livroDTO) {
		Livro livro = new Livro();
		toEntity(livroDTO, livro);
		livroRepository.save(livro);
		return "O livro foi cadastrado com o id: " + livro.getIdLivro();
	}
	
	// READ
	public LivroDTO buscarPorId(Integer idLivro) {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		
		// LIVRO VAZIO
		Livro livroBanco = new Livro();
		
		// DTO VAZIO
		LivroDTO livroDTO = new LivroDTO();
		
		if(livro.isPresent()) {
			livroBanco = livro.get();
			toDTO(livroBanco, livroDTO);
		}
		return livroDTO;
	}
	
	// UPDATE
	public String atualizar(Integer idLivro, LivroDTO livroDTO) {
		Optional<Livro> livro = livroRepository.findById(idLivro);
		Livro livroBanco = new Livro();
		
		if (livro.isPresent()) {
			livroBanco = livro.get();
			if (livroDTO.getTitulo() != null) {
				livroBanco.setTitulo(livroDTO.getTitulo());
			}
			if (livroDTO.getTipo() != null) {
				livroBanco.setTipo(livroDTO.getTitulo());
			}
			if (livroDTO.getAutor() != null) {
				livroBanco.setAutor(livroDTO.getAutor());
			}
			if (livroDTO.getDtPublicacao() != null) {
				livroBanco.setDtPublicacao(livroDTO.getAutor());
			}
			livroRepository.save(livroBanco);
		}
			return "O livro com id "+livroBanco.getIdLivro()+ " foi atualizado.";
	}
	
	// DELTE
	public void deletar(Integer idLivro) {
		livroRepository.deleteById(idLivro);
	}
	
	// LIVRO PARA DTO
	public LivroDTO toDTO(Livro livro, LivroDTO livroDTO) {
		
		livroDTO.setIdLivro(livro.getIdLivro());
		livroDTO.setTitulo(livro.getTitulo());
		livroDTO.setTipo(livro.getTitulo());
		livroDTO.setAutor(livro.getAutor());
		livroDTO.setDtPublicacao(livro.getAutor());
		
		return livroDTO;
	}
	
	// DTO PARA LIVRO
	public Livro toEntity(LivroDTO livroDTO, Livro livro) {
		
		//O ID NÃO É SETADO, PORQUE ELE É AUTOMÁTICO NA CLASSE
		livro.setTitulo(livroDTO.getTitulo());
		livro.setTipo(livroDTO.getTipo());
		livro.setAutor(livroDTO.getAutor());
		livro.setDtPublicacao(livroDTO.getDtPublicacao());
		
		return livro;	
	}
	
	//BUSCAR TODOS
	public List<LivroDTO> buscarTodos() {
		List<Livro> listaLivroEntidade = livroRepository.findAll();
		List<LivroDTO> listaLivroDTO = new ArrayList<>();
		
		for (Livro livro : listaLivroEntidade) {
			LivroDTO livroDTO = new LivroDTO();
			toDTO(livro, livroDTO);
			listaLivroDTO.add(livroDTO);
		}
		return listaLivroDTO;
	}
	
	// SALVAR LISTA
	public void salvarListaLivro(List<LivroDTO> listaLivroDTO) {
		List<Livro> listaLivro = new ArrayList<>();
		
		for (LivroDTO livroDTO : listaLivroDTO) {
			Livro livro = new Livro();
			toEntity(livroDTO, livro);
			listaLivro.add(livro);
		}
		livroRepository.saveAll(listaLivro);
	}
}