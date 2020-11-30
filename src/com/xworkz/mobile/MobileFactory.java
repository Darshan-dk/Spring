package com.xworkz.mobile;

public class MobileFactory {
	private String brand;//init using const		
	private double price;//init using const		
	private boolean lteSupported;// init using set	
	
	public MobileFactory() {
		System.out.println("nothing");
	}
	public MobileFactory(String brand) {
		this.brand=brand;
		System.out.println("The brand of the mobile "+brand);
	}
	public MobileFactory(double price) {
		this.price=price;
		System.out.println("The price of the mobile "+price);
	}
	public void setLteSupported(boolean lteSupported) {
		this.lteSupported=lteSupported;
		System.out.println("checking for the lte support");
		
	}
	public boolean isLteSupported() {
		return lteSupported;
	}

}
