package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculadora {

	@RequestMapping("/soma")
	public int soma(@RequestParam int num1, int num2) {
		return num1 + num2;
	}
	
	@RequestMapping("/sub")
	public int sub(@RequestParam int num1, int num2) {
		return num1 - num2;
	}
	
	@RequestMapping("/mult")
	public int mult(@RequestParam int num1, int num2) {
		return num1 * num2;
	}
	
	@RequestMapping("/div")
	public int div(@RequestParam int num1, int num2) {
		return num1 / num2;
	}
}