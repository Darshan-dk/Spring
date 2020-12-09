package com.xworkz.vehicle;

public class Vehicle {

	private String regNo;
	private String OwnerName;
	private Battery battery;
	private Fuel fuel;

	public Vehicle(String regNo, String ownerName, Battery battery, Fuel fuel) {
		super();
		this.regNo = regNo;
		OwnerName = ownerName;
		this.battery = battery;
		this.fuel = fuel;
	}

	public boolean start() {

		System.out.println("Vehicle Stat method is invoked");

		boolean started = false;
		boolean batteryWorking = battery.discharge();
		if (batteryWorking) {
			System.out.println("Battery working fine checking for the fuel");

			String burn = fuel.burn();
			if ("YES".equals(burn)) {
				System.out.println("Fuel is avilable Vehicle is starting");

			} else {
				System.out.println(" Vehicle is not starting Check the fuel and battery");
			}
		}
		return started;

	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

}
