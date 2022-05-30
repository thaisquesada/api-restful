package org.serratec.backend.projeto06.exception;

public class ClientException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ClientException() {
		super();
	}
	
	public ClientException(String message) {
		super(message);
	}
	
	public ClientException(String message, Exception cause) {
		super(message, cause);
	}
	public ClientException(Exception e) {
		super(e);
	}
	
}