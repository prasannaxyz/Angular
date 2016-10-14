package com.angularjs.practice;

import java.sql.Connection;
import java.sql.SQLException;

import com.common.util.DBConnection;

public class DBConnectionTest {

	public static void main(String args[]) throws InterruptedException {

		try {
			Connection con = DBConnection.getDBConnection().getConnection();
			if (con != null)
				System.out.println("DB Connection was successful");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
