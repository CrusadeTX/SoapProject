package com.project.server;
import java.util.List;


public class CarService {
	public static Repository repo = new Repository();

	public boolean AddCar(String Make, String Model, String registrationPlate, int Displacement, int Weight) {
		Car car = new Car(registrationPlate,Make,Model,Weight, Displacement);
		return repo.AddCar(car);
		
	}
	public boolean RemoveCar(String licensePlate) {
		Car car = repo.SearchByLicensePlate(licensePlate);
		return repo.RemoveCar(car);
	}
	public List<Car> GetAllCars(){
		return repo.getAllCars();
	}
	public Car getCarByPlate(String licensePlate) {
		return repo.SearchByLicensePlate(licensePlate);
	}

}
