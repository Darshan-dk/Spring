package com.xworkz.browser;

public class Internet {
	
	private String providerName;
	private String State;
	private int code;
	private Power power;
	
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	
	public void connect() {
		if(power.isAvilable())
			System.out.println("connected successfuly");
		else
			System.out.println("Power is no Avilable");
	}
	

}
