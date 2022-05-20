package org.serratec.backend.java.projeto02.service;

//faz todo o serviço

import java.util.ArrayList;

import java.util.List;

import org.serratec.backend.java.projeto02.entidade.Todo;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	List<Todo> lista = new ArrayList<>();

	//Create
	public void adicionar(Todo todo) {
		lista.add(todo);
	}

	//Read
	public List<Todo> listaTodo() {
		return this.lista;
	}

	//Update
	public void atualizar(Integer posicaoLista, Todo todoDaApi) {

		Todo todoDaListaSalva = new Todo();
		todoDaListaSalva = lista.get(posicaoLista);

		todoDaListaSalva.setId(todoDaApi.getId());
		todoDaListaSalva.setTitulo(todoDaApi.getTitulo());
		todoDaListaSalva.setDescricao(todoDaApi.getDescricao());

	}
	
	//Delete
	public void deletar(int posicaoLista) {
		lista.remove(posicaoLista);
	}

	public Todo buscarPorId(Integer idTodo) {
		
		Todo todoNoBanco = new Todo();
		
		for (Todo todo : lista) {
			if(todo.getId().equals(idTodo)) {
				todoNoBanco = todo;
			}
		}
		return todoNoBanco;
	}
	
}