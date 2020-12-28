package com.xworkz.login.component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class Cart {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pdname = (String) req.getAttribute("pn");
		String pdqty = (String) req.getAttribute("pq");
		String brand = (String) req.getAttribute("pb");
		String price = (String) req.getAttribute("pp");

		
		int pq = Integer.parseInt(pdqty);
		double pr = Integer.parseInt(pdqty);
		
		
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("product name:"+pdname+" Price:"+pr+" brand:"+brand+" quantity"+pq);
	}

}

