package org.serratec.backend.projeto06.controller;

import java.util.List;

import org.serratec.backend.projeto06.dto.CarDTO;
import org.serratec.backend.projeto06.exception.CarException;
import org.serratec.backend.projeto06.service.CarService;
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
@RequestMapping
public class CarController {

	@Autowired
	CarService carService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody CarDTO carDTO) {
		return ResponseEntity.ok(carService.save(carDTO));
	}
	
	@GetMapping("/search/{carId}")
	public ResponseEntity<CarDTO> searchById(@PathVariable Integer carId) throws CarException {
		return ResponseEntity.ok(carService.searchById(carId));
	}
	
	@PutMapping("/update/{carId}")
	public ResponseEntity<String> update(@PathVariable Integer carId, @RequestBody CarDTO carDTO) throws CarException {
		return ResponseEntity.ok(carService.update(carId, carDTO));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> delete(@PathVariable Integer carId) {
		carService.delete(carId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<CarDTO>> findAll() {
		return ResponseEntity.ok(carService.findAll());
	}
}