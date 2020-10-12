package javaweb_excercise_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	public static void main(String[] args) {
		Statement stmt = null;
		Connection conn = null;

		try {
			String hostName = "localhost";
			String dbName = "javawweb92020_excercise3";
			String userName = "root";
			String password = "haha1994MYSQL";
			String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(connectionURL, userName, password);
			System.out.println("Connected database successfully...");

			// Execute query to get districts
			stmt = conn.createStatement();
			String sql = "select district from district ";
			ResultSet rs = stmt.executeQuery(sql);

			// Display districts
			System.out.println("//////////////*District List*///////////");
			while (rs.next()) {
				// Retrieve by column name
				String district = rs.getString("district");
				System.out.println("//////////////" + district + "///////////");
			}

			// Display transaction category
			sql = "select category from transaction_category";
			rs = stmt.executeQuery(sql);

			System.out.println("//////////*Transaction Category List*/");
			while (rs.next()) {
				// Retrieve by column name
				String transCategory = rs.getString("category");
				System.out.println("//////////////" + transCategory + "///////////");
			}

			// Display building category
			sql = "select category from building_category";
			rs = stmt.executeQuery(sql);

			System.out.println("//////////*Transaction Category List*/");
			while (rs.next()) {
				// Retrieve by column name
				String buildingCategory = rs.getString("category");
				System.out.println("//////////////" + buildingCategory + "///////////");
			}
			rs.close();

		} catch (SQLException e) {
			System.out.println(e);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();

			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
				System.out.println("Closed connection!");
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}

	}

}
