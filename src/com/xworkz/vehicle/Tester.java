package com.xworkz.vehicle;

public class Tester {

	public static void main(String[] args) {

		Battery excide = new Battery();
		excide.setCapacity(2);

		Fuel petrol = new Fuel();
		petrol.setQuantity(0);

		Vehicle car = new Vehicle("KA 01 AA 333", "Darshan", excide, petrol);
		car.start();

	}

}
