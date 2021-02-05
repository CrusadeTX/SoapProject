package com.project.server;


import java.util.ArrayList;


public class Repository {

	private ArrayList<Car> Cars =new ArrayList<Car>();
	private Car car;
	
	public boolean AddCar(Car car) {
		return Cars.add(car);
	}
	public boolean RemoveCar(Car car) {
		return Cars.remove(car);
	}
	public Car SearchByLicensePlate(String licensePlate) {
		for (int i=0;i<=Cars.size();i++) {
			if(licensePlate.equals(Cars.get(i).LicensePlate)) {
				car = Cars.get(i);
				return car;
				
			}
		}
		return null;
		
	}
	public ArrayList<Car>getAllCars(){
		return Cars;
	}
}
