package org.serratec.backend.projeto03.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto03.entity.Conta;
import org.serratec.backend.projeto03.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	public void salvar(Conta conta) {
		contaRepository.save(conta);
	}

	public Conta buscarPorId(Integer idConta) {
		Optional<Conta> conta = contaRepository.findById(idConta);

		// conta vazia
		Conta contaNoBanco = new Conta();

		if (conta.isPresent()) {
			// conta vazia recebe conta do banco
			contaNoBanco = conta.get();
		}
		return contaNoBanco;
	}

	public void atualizar(Integer idConta, Conta conta) {
		Conta contaNoBanco = buscarPorId(idConta);
		
		if(conta.getTitular() != null) {
			contaNoBanco.setTitular(conta.getTitular());
		}
			
		if(conta.getSaldo() != null) {
			contaNoBanco.setSaldo(conta.getSaldo());
		}
	}
	
	public void deletar(Integer idCliente) {
		contaRepository.deleteById(idCliente);
	}

	public List<Conta> listartodos() {
		return contaRepository.findAll();
	}

	public void salvarTodos(List<Conta> listaConta) {
		contaRepository.saveAll(listaConta);
	}

	public void sacar(Integer idConta, Double valor) throws OperacaoException {
		Conta contaDebito = new Conta();
		Optional<Conta> contaDeb = contaRepository.findById(idConta);
		
		if (contaDeb.isPresent()) {
			contaDebito = contaDeb.get();
		}
		
		if (contaDebito.getSaldo() < valor) {
			throw new OperacaoException(valor);
		} else {
			contaDebito.setSaldo(contaDebito.getSaldo() - valor);
		}
	}

	public void depositar(Integer idConta, Double valor) throws OperacaoException {
		Conta contaCredito = new Conta();
		Optional<Conta> contaCred = contaRepository.findById(idConta);
		
		if (contaCred.isPresent()) {
			contaCredito = contaCred.get();
		}
		
		if (valor < 0) {
			throw new OperacaoException(valor);
		} else {
			contaCredito.setSaldo(contaCredito.getSaldo() + valor);
		}
	}
}