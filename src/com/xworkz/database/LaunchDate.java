package com.xworkz.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LaunchDate {
	
	public String LaunchingDate(String dt) throws ParseException { 
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		String dt= "17/12/2020";
		Date data=(sdf.parse(dt));
		String date = (sdf.format(data));
		System.out.println(date);
		return date;
	}

}
