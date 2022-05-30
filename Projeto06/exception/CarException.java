package org.serratec.backend.projeto06.exception;

public class CarException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CarException() {
		super();
	}
	
	public CarException(String message) {
		super(message);
	}
	
	public CarException(String message, Exception cause) {
		super(message, cause);
	}
	public CarException(Exception e) {
		super(e);
	}
	
}
