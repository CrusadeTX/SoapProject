package com.project.server;
import java.util.ArrayList;


public class CarService {
	public Repository repo = new Repository();

	public boolean AddCar(String LicensePlate, String Make, String Model, int Weight, int Displacement) {
		Car car = new Car(LicensePlate,Make,Model,Weight,Displacement);
		boolean result = repo.AddCar(car);
		return result;
		
	}
	public boolean RemoveCar(Car car) {
		return repo.RemoveCar(car);
	}
	public ArrayList<Car> GetAllCars(){
		return repo.getAllCars();
	}
	public Car getCarByPlate(String licensePlate) {
		return repo.SearchByLicensePlate(licensePlate);
	}

}
