package com.project.server;


import java.util.ArrayList;


public class Repository {
	private ArrayList<Car> Cars;
	public Repository() {
		Cars =new ArrayList<Car>();
		Car Samplecar= new Car("12345","Make","Model",1300,2);
		Car Samplecar2= new Car("fffff","Make2","Model2",1400,3);
		Car Samplecar3= new Car("ggggg","Honda","Civic",1200,2);
		Car Samplecar4= new Car("hhhhh","Mazda","MX5",1300,2);
		Cars.add(Samplecar);
		Cars.add(Samplecar2);
		Cars.add(Samplecar3);
		Cars.add(Samplecar4);
		
	}

	 
	
	public boolean AddCar(Car car) {
		return Cars.add(car);
	}
	public boolean RemoveCar(Car car) {
		return Cars.remove(car);
	}
	public Car SearchByLicensePlate(String licensePlate) {
		
		if(Cars.size()>0) {
			for(Car car : Cars) {
				if(car.getLicensePlate().equals(licensePlate)) {
					return car;
				}
			}
		}
		return null;
		
	}
	public ArrayList<Car>getAllCars(){
		if(Cars.size()>0) {
		return Cars;
		}
		else {
			return null;
		}
	}
}
