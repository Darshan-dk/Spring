package com.xworkz.monitor;

public class MonitorFactory {
	
	private int width;//init using const		
	private int height;//init using const		
	private String modelNo;//init using set		
	private String mfgDate;//init using set		

	public MonitorFactory() {
		System.out.println(this.getClass().getSimpleName());
	}
	public MonitorFactory(int width, int height) {
		this.width=width;
		this.height=height;
		System.out.println("Width of the monitor is "+width);
		System.out.println("hight of the monitor is "+height);
	}
	
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
		System.out.println("Setter method is invoked");
	}

	public String getModelNo() {
		return modelNo;
		
	}
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
		System.out.println("the mfg date is :"+mfgDate);
	}
	public String getMfgDate() {
		return mfgDate;
		
	}
	
	
	
	
	
}
