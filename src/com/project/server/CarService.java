package com.project.server;
import java.util.List;


public class CarService {
	public Repository repo = new Repository();
	public List<Car> GetAllCars(){
		return repo.getAllCars();
	}
	public Car getCarByPlate(String licensePlate) {
		return repo.SearchByLicensePlate(licensePlate);
	}

}
