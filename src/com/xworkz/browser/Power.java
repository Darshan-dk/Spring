package com.xworkz.browser;

public class Power {
	
	private boolean avilable;
	


	public Power(boolean avilable) {
		super();
		this.avilable = avilable;
		System.out.println(this.getClass().getSimpleName()+" constructer createad");
	}

	public boolean isAvilable() {
		return avilable;
	}

	public void setAvilable(boolean avilable) {
		this.avilable = avilable;
	}
	

}
