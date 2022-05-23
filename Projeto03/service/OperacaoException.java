package org.serratec.backend.projeto03.service;

public class OperacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public OperacaoException(Double valor) {
		System.out.print("Valor inválido!");
	}

}