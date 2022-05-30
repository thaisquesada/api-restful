package org.serratec.backend.projeto06.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value 
		      = {CarException.class })
	protected ResponseEntity<Object> notFound(CarException ex) {		
	       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
	       return buildResponseEntity(apiError);
	   }
	
	@ExceptionHandler(value 
		      = {ClientException.class })
	protected ResponseEntity<Object> notFound(ClientException ex) {		
	       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
	       apiError.setMessage(ex.getMessage());
	       apiError.setDebugMessage(ex.getLocalizedMessage());
	       return buildResponseEntity(apiError);
	   }
	
private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }

}