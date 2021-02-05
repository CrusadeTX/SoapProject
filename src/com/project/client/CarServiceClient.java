package com.project.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.project.client.CarServiceStub.*;



public class CarServiceClient {
	public static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoadOptions();

	}
	
	public static void LoadOptions() {
		try {
		System.out.println("Select an option: 1 - Add a car, 2 - Remove a Car, 3 - Search By Car NumberPlate, 4 - Get All Cars");
	        String input = reader.readLine();
	        switch(input) {
	        case "1": AddCar(); break;
	        case "2": RemoveCar();break;
	        case "3": Search();break;
	        case "4": GetAllCars();break;
	        default : 
	        	System.out.println("You have entered an ivalid option!"); 
	        	LoadOptions();break;
	        	
	        }
		}
	        catch(IOException e) {
	        	e.printStackTrace();
	        }
	}

	private static void GetAllCars() {
		
		
	}

	private static void Search() {
		// TODO Auto-generated method stub
		
	}

	private static void RemoveCar() {
		// TODO Auto-generated method stub
		
	}

	private static void AddCar() {
		try {
		String LicensePlate;
		String Make;
		String Model;
		int Weight;
		int Displacement;
		System.out.println("Enter License Plate");	       
        LicensePlate =ValidateStrings(reader.readLine(),"License Plate");
        System.out.println("Enter Make");
        Make = ValidateStrings(reader.readLine(),"Make");
        System.out.println("Enter Model");
        Model = ValidateStrings(reader.readLine(),"Model");
        System.out.println("Enter Weight");
        Weight = ValidateInts(reader.readLine(),"Weight");
        System.out.println("Enter Displacement");
        Displacement = ValidateInts(reader.readLine(),"Displacement");
        System.out.println(LicensePlate + Make + Model + String.valueOf(Weight)+ String.valueOf(Displacement));      
        CarServiceStub stub = new CarServiceStub();
        AddCar request = new AddCar();
        request.setDisplacement(Displacement);
        request.setLicensePlate(LicensePlate);
        request.setMake(Make);
        request.setModel(Model);
        request.setWeight(Weight);
        AddCarResponse response =stub.addCar(request);
        System.out.println("Result: "+ response.get_return());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
        
		
		
		
	}
	public static String ValidateStrings(String input, String name) {
		String result=null;
		try {
		while(input.trim().length()==0) {
        	System.out.println(name +" cannot be empty");
        	System.out.println("Enter "+name);
        	
				input = reader.readLine();
			
        	
		}
		return result= input;
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return result;

	}
	public static int ValidateInts(String input, String name) {
		int result =0;
		try {

		
		while(input.trim().length()==0) {
        	System.out.println(name +" cannot be empty");
        	System.out.println("Enter "+name);
        	input = reader.readLine();
        	
        }
		
		
			return result = Integer.parseInt(input);
			
		}
		catch(NumberFormatException e) {
			System.out.println(name +" is not a valid number");
			LoadOptions();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	

}
