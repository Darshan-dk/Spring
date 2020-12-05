package com.xworkz.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RocketDAO {

	private String username;
	private String password;
	private String url;
	private String driverClass;

	Connection connection = null;

	public RocketDAO() {
		System.out.println("Created " + this.getClass().getSimpleName());
	}

	public RocketDAO(String url, String driverClass) {

		System.out.println("Created with url and driverClass" + this.getClass().getSimpleName());

		this.url = url;
		this.driverClass = driverClass;
	}

	public void initResource() throws SQLException {
//		System.out.println("this method is used to init resource like connection, file or any other resources");
		if (!username.isEmpty() && !password.isEmpty() && !url.isEmpty() && !driverClass.isEmpty()) {
			System.out.println("write code to connect to db...");
		} else {
			System.out.println("resources properties are not availbale");
		}
		connection = DriverManager.getConnection(url, this.username, this.password);
	}

	public void save(RocketDTO dto) {
		System.out.println("saving data");
		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into spring_example.rocket values(?,?,?,?)");
			statement.setString(2, dto.getCountryName());
			statement.setString(4, dto.getLaunchDate());
			statement.setDouble(3, dto.getCost());
			statement.setInt(1, dto.getId());
			int rowsEffected = statement.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println(" Saved successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(RocketDTO dto) {
		System.out.println("deleting data");
		try {
			PreparedStatement statement1 = connection.prepareStatement("delete from spring_example.rocket where id=?");
			statement1.setInt(1, dto.getId());
			int rowsDeleted = statement1.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println(" deleted successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(RocketDTO dto) {
		System.out.println("Updating data");
		try {

			PreparedStatement statement = connection
					.prepareStatement("update spring_example.rocket set countryName=? where id=?");
			statement.setInt(2, dto.getId());
			statement.setString(1, dto.getCountryName());
			int rowsEffected = statement.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println(" Updated successfully");
			}
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
				String date = res.getString(4);

				System.out.println(id + "	" + name + "	" + cost+"	  "+date);
			}
			System.out.println("Fetching completed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeResource() {
		System.out.println("this method is used to close resource like connection, file or any other resources");

	}

	public void setUsername(String username) {
		System.out.println("invoked setUsername :" + username);
		this.username = username;
	}

	public void setPassword(String password) {
		System.out.println("invoked setPassword :" + password);
		this.password = password;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
