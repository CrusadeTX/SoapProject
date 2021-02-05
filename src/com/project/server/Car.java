package com.project.server;

public class Car {

	public Car(String LicensePlate,String Make,String Model,int Weight,int Displacement ) {
		this.LicensePlate=LicensePlate;
		this.Make=Make;
		this.Model = Model;
		this.Weight = Weight;
		this.Displacement= Displacement;

	}

	public String getLicensePlate() {
		return LicensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		LicensePlate = licensePlate;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public int getDisplacement() {
		return Displacement;
	}

	public void setDisplacement(int displacement) {
		Displacement = displacement;
	}

	private String LicensePlate;
	private String Make;
	private String Model;
	private int Weight;
	private int Displacement;

	public String CalculateRoadTaxClass() {
		if (this.Weight > 0 || this.Weight < 1000) {
			return "Lowest Road Tax Class";
		}
		if (this.Weight > 1000 || this.Weight < 2000) {
			return "Medium Road Tax Class";
		}
		if (this.Weight > 2000) {
			return "Highest Road Tax Class";
		}
		return "Invalid Data";
	}

	public String CalculateInsuranceClass() {
		if (this.Displacement > 0 || this.Displacement < 1.4) {
			return "Lowest Insurance Class";
		}
		if (this.Displacement > 1.4 || this.Displacement < 2.4) {
			return "Medium Insurance Class";
		}
		if (this.Displacement > 2000) {
			return "Highest Insurance Class";
		}
		return "Invalid Data";
	}

}
