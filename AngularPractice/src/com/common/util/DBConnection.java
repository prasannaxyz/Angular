package com.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static DBConnection dbConnect = null;
	private static final Properties prop = new PropertyManager()
			.loadPropertiesFile("DBConfig.properties");

	public static synchronized DBConnection getDBConnection() {
		if (dbConnect == null) {
			dbConnect = new DBConnection();
		}
		return dbConnect;
	}

	public Connection getConnection() {
		Connection con = null;
		try {

			Class.forName(prop.getProperty("DRIVERNAME"));
			con = DriverManager.getConnection(prop.getProperty("URL"),
					prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

}
