package org.serratec.backend.java.projeto02.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.java.projeto02.entidade.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	List<Cliente> lista = new ArrayList<>();
	
	//create
	public void adicionar(Cliente cliente) {
		lista.add(cliente);
	}
	
	//read
	public List<Cliente> listaCliente() {
		return this.lista;
	}
	
	//update
	public void atualizar(Integer posicaoLista, Cliente clienteDaApi) {

	Cliente clienteDaListaSalva = new Cliente();
	clienteDaListaSalva = lista.get(posicaoLista);
	
	clienteDaListaSalva.setIdCliente(clienteDaApi.getIdCliente());
	clienteDaListaSalva.setNomeCompleto(clienteDaApi.getNomeCompleto());
	clienteDaListaSalva.setNomeUsuario(clienteDaApi.getNomeUsuario());
	clienteDaListaSalva.setEmail(clienteDaApi.getEmail());
	clienteDaListaSalva.setCpf(clienteDaApi.getCpf());
	clienteDaListaSalva.setDataNasc(clienteDaApi.getDataNasc());
	clienteDaListaSalva.setEndereco(clienteDaApi.getEndereco());
	clienteDaListaSalva.setTel(clienteDaApi.getEndereco());
	}
	
	//delete
	public void deletar(int posicaoLista) {
		lista.remove(posicaoLista);
	}
	
	//search by id
	public Cliente buscarPorId(Integer idCliente) {
		
		Cliente clienteNoBanco = new Cliente();
		
		for (Cliente cliente : lista) {
			if(cliente.getIdCliente().equals(idCliente)) {
				clienteNoBanco = cliente;
			}
		}
		return clienteNoBanco;
	}
	
}