package com.xworkz.init.setter;

public class Hotel {

	private String name;
	private boolean type;
	private String place;

	public Hotel() {
		System.out.println("cereated " + this.getClass().getSimpleName());
	}

	public Hotel(String name) {
		System.out.println("class " + this.getClass().getSimpleName() + "  single parameter construcotr is created");
		System.out.println("The name of the hotel is " + name);
	}

	public void setType(boolean type) {
		System.out.println("Hotel type is Initilaized" );
		this.type = type;
	}

	public void getType(boolean type) {
		this.type = type;
	 	if (type == true) {
			System.out.println("type of hotel is vegiterian ");

		} else
			System.out.println("type of hotel is nonVeg ");
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		System.out.println("the hotel is in " + place);
		this.place = place;
	}

}
