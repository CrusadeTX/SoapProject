package com.project.server;


import java.util.ArrayList;


public class Repository {
	private static ArrayList<Car> Cars =new ArrayList<Car>();
	public Repository() {
		
		Car Samplecar= new Car("1","2","3",4,5);
		Car Samplecar2= new Car("2","2dsf","3a",4,5);
		Car Samplecar3= new Car("3","2sa","dsadsad3",4,5);
		Car Samplecar4= new Car("4","2ds","3dsdas",4,5);
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
