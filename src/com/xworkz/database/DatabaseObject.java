package com.xworkz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseObject {

	private String username;
	private String password;
	private String url;
	private String driverClass;

	public DatabaseObject() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	public DatabaseObject(String url, String driverClass) {
		super();
		System.out.println("Created with url and driverClass" + this.getClass().getSimpleName());

		this.url = url;
		this.driverClass = driverClass;
	}

	public void initResource() {
		System.out.println("this method is used to init resource like connection, file or any other resources");
		if (!username.isEmpty() && !password.isEmpty() && !url.isEmpty() && !driverClass.isEmpty()) {
			System.out.println("write code to connect to db");
		} else {
			System.out.println("resources properties are not availbale");
		}
	}

	public void save() {
		System.out.println("saving data");
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement createStatement = connection.createStatement();

			createStatement.execute("insert into spring_example.rocket values (3,'usa',115445.2455654)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		System.out.println("delete data");
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement createStatement = connection.createStatement();

			createStatement.execute("delete from spring_example.rocket where id=1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		System.out.println("Updating data");
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement createStatement = connection.createStatement();

			createStatement.execute("update spring_example.rocket set name='india' where id=2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fetch() {
		System.out.println("fetching data");
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement createStatement = connection.createStatement();
			ResultSet res = createStatement.executeQuery("select * from spring_example.rocket");
			while (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				Double cost = res.getDouble(3);

				System.out.println(id + " " + name + " " + cost);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeResource() {
		System.out.println("this method is used to close resource like connection, file or any other resources");

	}

	public void setUsername(String username) {
		System.out.println("invoked setUsername" + username);
		this.username = username;
	}

	public void setPassword(String password) {
		System.out.println("invoked setPassword" + password);
		this.password = password;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
