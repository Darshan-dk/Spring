package com.xworkz.browser;

public class Browser {
	
	public Internet getNet() {
		return net;
	}

	public void setNet(Internet net) {
		this.net = net;
	}


	private Internet net;
	
	
	public void connect() {
		this.net.connect();
		System.out.println("connected successfully");
	}

}
