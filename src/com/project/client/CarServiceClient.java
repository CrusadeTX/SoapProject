package com.project.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.apache.axis2.AxisFault;

import com.project.client.CarServiceStub.*;

public class CarServiceClient {
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoadOptions();

	}

	public static void LoadOptions() {
		try {
			System.out.println(
					"Select an option: 1 - Add a car, 2 - Remove a Car, 3 - Search By Car NumberPlate, 4 - Get All Cars");
			String input = reader.readLine();
			switch (input) {
			case "1":
				AddCar();
				break;
			case "2":
				RemoveCar();
				break;
			case "3":
				Search();
				break;
			case "4":
				GetAllCars();
				break;
			default:
				System.out.println("You have entered an ivalid option!");
				LoadOptions();
				break;

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void GetAllCars() {
		try {
			CarServiceStub stub = new CarServiceStub();
			GetAllCars request = new GetAllCars();
			GetAllCarsResponse response = stub.getAllCars(request);
			Car[] Cars = response.get_return();
			for(Car car : Cars) {
				System.out.println("Make: "+ car.getMake() +" Model: "+ car.getMake()+ " RegistrationPlate: "+car.getLicensePlate());
			}
			LoadOptions();
			
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void Search() {
		try {
			String LicensePlate;
			System.out.println("Enter License Plate");
			LicensePlate = ValidateStrings(reader.readLine(), "License Plate");
			CarServiceStub stub = new CarServiceStub();
			GetCarByPlate request = new GetCarByPlate();
			request.setLicensePlate(LicensePlate);
			GetCarByPlateResponse response = stub.getCarByPlate(request);
			if (response.get_return() == null) {
				System.out.println("No such car exists");
			} else {
				Car car = response.get_return();
				System.out.println("Retrieved Car: " + " Make: "+ car.getMake() + " Model: "+ car.getModel() + " RegistrationPlate: "+car.getLicensePlate()
						+ " Weight: "+car.getWeight() + " Engine Displacement: "+car.getDisplacement());

			}
			LoadOptions();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void RemoveCar() {
		try {
			String LicensePlate;
			System.out.println("Enter License Plate");
			LicensePlate = ValidateStrings(reader.readLine(), "License Plate");
			CarServiceStub stub = new CarServiceStub();
			RemoveCar request = new RemoveCar();
			request.setLicensePlate(LicensePlate);
			RemoveCarResponse response = stub.removeCar(request);
			System.out.println("Response: "+response.get_return());
			LoadOptions();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void AddCar() {
		try {
			String LicensePlate;
			String Make;
			String Model;
			int Weight;
			int Displacement;
			System.out.println("Enter License Plate");
			LicensePlate = ValidateStrings(reader.readLine(), "License Plate");
			System.out.println("Enter Make");
			Make = ValidateStrings(reader.readLine(), "Make");
			System.out.println("Enter Model");
			Model = ValidateStrings(reader.readLine(), "Model");
			System.out.println("Enter Weight");
			Weight = ValidateInts(reader.readLine(), "Weight");
			System.out.println("Enter Displacement");
			Displacement = ValidateInts(reader.readLine(), "Displacement");
			System.out.println(LicensePlate + Make + Model + String.valueOf(Weight) + String.valueOf(Displacement));
			CarServiceStub stub = new CarServiceStub();
			AddCar request = new AddCar();
			request.setDisplacement(Displacement);
			request.setRegistrationPlate(LicensePlate);
			request.setMake(Make);
			request.setModel(Model);
			request.setWeight(Weight);
			AddCarResponse response = stub.addCar(request);
			System.out.println("Result: " + response.get_return());
			LoadOptions();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String ValidateStrings(String input, String name) {
		String result = null;
		try {
			while (input.trim().length() == 0) {
				System.out.println(name + " cannot be empty");
				System.out.println("Enter " + name);

				input = reader.readLine();

			}
			return result = input;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	public static int ValidateInts(String input, String name) {
		int result = 0;
		try {

			while (input.trim().length() == 0) {
				System.out.println(name + " cannot be empty");
				System.out.println("Enter " + name);
				input = reader.readLine();

			}

			return result = Integer.parseInt(input);

		} catch (NumberFormatException e) {
			System.out.println(name + " is not a valid number");
			LoadOptions();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

}
