package org.serratec.backend.projeto06.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto06.dto.CarDTO;
import org.serratec.backend.projeto06.entity.Car;
import org.serratec.backend.projeto06.exception.CarException;
import org.serratec.backend.projeto06.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	CarRepository carRepository;

	// TO DTO
	public CarDTO toDTO(Car car, CarDTO carDTO) {

		carDTO.setCarId(car.getCarId());
		carDTO.setModel(car.getModel());
		carDTO.setBrand(car.getBrand());
		carDTO.setYear(car.getYear());

		return carDTO;
	}

	// TO ENTITY
	public Car toEntity(Car car, CarDTO carDTO) {

		car.setModel(carDTO.getModel());
		car.setBrand(carDTO.getBrand());
		car.setYear(carDTO.getYear());

		return car;
	}

	// CREATE
	public String save(CarDTO carDTO) {
		Car car = new Car();
		toEntity(car, carDTO);
		carRepository.save(car);
		return "Car successfully saved!";
	}

	// READ
	public CarDTO searchById(Integer carId) throws CarException {
		Optional<Car> car = carRepository.findById(carId);
		Car dataCar = new Car();
		CarDTO carDTO = new CarDTO();

		if (car.isPresent()) {
			dataCar = car.get();
			toDTO(dataCar, carDTO);
			return carDTO;
		}
		throw new CarException("Car " + dataCar.getCarId() + " not found! Please, try again.");
	}

	// UPDATE

	public String update(Integer carId, CarDTO carDTO) throws CarException {
		Optional<Car> car = carRepository.findById(carId);
		Car dataCar = new Car();

		if (car.isPresent()) {
			dataCar = car.get();
			if (carDTO.getModel() != null) {
				dataCar.setModel(carDTO.getModel());
			}
			if (carDTO.getBrand() != null) {
				dataCar.setBrand(carDTO.getBrand());
			}
			if (carDTO.getYear() != null) {
				dataCar.setYear(carDTO.getYear());
			}
			carRepository.save(dataCar);
		}
		throw new CarException("Car " + dataCar.getCarId() + " was not updated! Please, try again.");
	}

	// DELETE
	public void delete(Integer carId) {
		carRepository.deleteById(carId);
	}

	// LIST ALL
	public List<CarDTO> findAll() {
		List<Car> carList = carRepository.findAll();
		List<CarDTO> carDTOList = new ArrayList<>();

		for (Car car : carList) {
			CarDTO carDTO = new CarDTO();
			toDTO(car, carDTO);
			carDTOList.add(carDTO);
		}
		return carDTOList;
	}
}