package com.xworkz.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RocketDTO {

	private int id;
	private String countryName;
	private Double cost;
	private String launchDate;

	public RocketDTO() {
		System.out.println("Initializing the DTO class");
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

//	public String getLaunchDate() throws ParseException {
//		String dt= launchDate;
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////		String dt= "17/12/2020";
//		Date data=(sdf.parse(dt));
//		String date = (sdf.format(data));
//		System.out.println(date);
//		return date;
//	}

	public String getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(String launchDate) {
		this.launchDate = launchDate;
	}

}
