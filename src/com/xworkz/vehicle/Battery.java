package com.xworkz.vehicle;

public class Battery {

	private int capacity;
	private int power;

	public boolean charge() {
		boolean charging = false;
		if (this.power > 100) {
			System.out.println("Battery is charging");
			charging = true;
		} else
			System.out.println("battery is not charging");
		return charging;
	}

	public boolean discharge() {
		boolean working = false;
		if (capacity > 0) {
			System.out.println("the battery is discharging");
			working = true;
		} else
			System.out.println("Battery is not Working");

		return working;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
