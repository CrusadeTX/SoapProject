package com.project.server;
import java.util.List;


public class CarService {
	public Repository repo;

	public boolean AddCar(Car car) {
		return repo.AddCar(car);
		
	}
	public boolean RemoveCar(Car car) {
		return repo.RemoveCar(car);
	}
	public List<Car> GetAllCars(){
		return repo.getAllCars();
	}
	public Car getCarByPlate(String licensePlate) {
		return repo.SearchByLicensePlate(licensePlate);
	}

}
