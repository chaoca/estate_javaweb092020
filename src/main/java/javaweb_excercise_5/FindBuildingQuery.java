package javaweb_excercise_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class FindBuildingQuery {
	public static void main(String[] args) {
		Statement stmt = null;
		Connection conn = null;

		try {
			//Connect DB by jdbc
			String hostName = "localhost";
			String dbName = "javaweb62020module1basic";
			String userName = "root";
			String password = "haha1994MYSQL";
			String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(connectionURL, userName, password);
			System.out.println("Connected database successfully...");
			
			String name = "";
			String ward = "Phường 2";
			String districtCode = "Q1";
			String street = "";
			String basementNum = "";
			String direction = "";
			String level = "";
			String rentPriceFrom = "";
			String rentPriceTo = "";
			String manager = "";
			String managerNumber = "";
			// String[] buildingRentType = {"nguyen-can", "noi-that"};
			String[] buildingRentType = { "", "", "" };
			String rentAreaFrom = "200";
			String rentAreaTo = "";
			String assignedStaff = "nguyen van c";
			String sql = "";
			String sql2 = "";
			String sql3 = "";
			String sql4 = "";
			
			// Search buildingid from building fields
			sql = "select b.id as buildingid, d.name as district \r\n"
					+ "from building as b inner join district as d\r\n" + "on b.districtid = d.id";		
			if (!districtCode.equals("")) {
				sql = sql + " where d.code ='" + districtCode + "' ";
			}
			if (!name.equals("")) {
				sql = sql + "and name ='" + name + "' ";
			}
			if (!ward.equals("")) {
				sql = sql + "and ward ='" + ward + "' ";
			}
			if (!street.equals("")) {
				sql = sql + "and street ='" + street + "' ";
			}
			if (!basementNum.equals("")) {
				sql = sql + "and numberofbasement = " + Integer.valueOf(basementNum) + " ";
			}
			if (!direction.equals("")) {
				sql = sql + "and direction = '" + direction + "' ";
			}
			if (!level.equals("")) {
				sql = sql + "and level = '" + level + "' ";
			}
			if (!manager.equals("")) {
				sql = sql + "and manager = '" + manager + "' ";
			}
			if (!managerNumber.equals("")) {
				sql = sql + "and mmanagernumber = " + Integer.valueOf(managerNumber) + " ";
			}
			if (!rentPriceFrom.equals("")) {
				sql = sql + "and rentprice >= " + Integer.valueOf(rentPriceFrom) + " ";
			}
			if (!rentPriceTo.equals("")) {
				sql = sql + "and rentprice <= " + Integer.valueOf(rentPriceTo) + " ";
			}

			if (sql.length() > 115 && !sql.substring(115, 121).equals(" where")) {
				sql = sql.substring(0, 115) + " where " + sql.substring(118, sql.length() - 1);
			}

			// Search buildingid from rentarea
			sql2 = "select buildingid, value as rentarea from rentarea where ";
			if (!rentAreaFrom.equals("")) {
				sql2 = sql2 + Integer.valueOf(rentAreaFrom) + "<= value ";
			}
			if (!rentAreaTo.equals("")) {
				sql2 = sql2 + "and value <=" + Integer.valueOf(rentAreaTo);
			}
			if (sql2.equals("select buildingid, value as rentarea from rentarea where ")) {
				sql2 = "";
			} else if (sql2.substring(57, 60).equals("and")) {
				sql2 = sql2.substring(0, 57) + sql2.substring(60);
			}

			// search buildingid from renttype
			sql3 = "SELECT bdrt.buildingid, rt.code as buildingtypecode\r\n"
					+ "FROM buildingrenttype bdrt left join renttype rt \r\n" + "on bdrt.renttypeid = rt.id\r\n"
					+ "having buildingtypecode in (";
			String copystr = sql3;
			for (String s : buildingRentType) {
				if (!s.equals(null) && !s.equals("")) {
					sql3 = sql3 + "'" + s + "',";
				}
			}
			sql3 = sql3 + ")";
			if (sql3.equals(copystr + ")")) {
				sql3 = "";
			} else {
				sql3 = sql3.substring(0, sql3.length() - 2) + sql3.charAt(sql3.length() - 1);// delete the last ","
			}

			// search buildingid from assignedstaffname
			if (!assignedStaff.equals("")) {
				sql4 = "SELECT ab.buildingid, fullname as staffname \r\n" + "FROM assignmentbuilding ab left join\r\n"
						+ "(select userid, fullname from\r\n"
						+ "	(SELECT   userid, code FROM user_role left join role\r\n"
						+ "	on user_role.roleid = role.id where code = 'staff'\r\n" + "	)as TableA \r\n"
						+ "	left join user \r\n" + "	on TableA.userid = user.id\r\n" + ")as TableB\r\n"
						+ "on ab.staffid = TableB.userid \r\n" + "where fullname = '" + assignedStaff + "'";
			}
			
			// inner join tables for result 
			if (!sql2.equals("")) {
				sql = "select table2.buildingid, district from (" + sql + ") as table2 inner join (" + sql2
						+ ")as table3 on table2.buildingid = table3.buildingid";
			}

			if (sql.equals("")) {
				sql = sql3;
			} else if (!sql3.equals("")) {
				sql = "select table4.buildingid, district from (" + sql + ") as table4 inner join (" + sql3
						+ ")as table5 on table4.buildingid = table5.buildingid";
			}

			if (sql.equals("")) {
				sql = sql4;
			} else if (!sql4.equals("")) {
				sql = "select table6.buildingid, district from (" + sql + ") as table6 inner join (" + sql4
						+ ")as table7 on table6.buildingid = table7.buildingid";
			}
			
			// print result
			stmt = conn.createStatement();
			sql = "select distinct *  from (" + sql
					+ ") as table8 inner join building where table8.buildingid = building.id";
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("/*Found building List*/");
			while (rs.next()) {
				
				// Retrieve by column name
				Date createdDate = rs.getDate("createddate");
				String buildingname = rs.getString("name");
				String address = rs.getString("street") + ", " + rs.getString("ward") + ", " + rs.getString("district")
						+ ", ";
				String managerName = rs.getString("manager");
				String managerNum = rs.getString("managernumber");
				String floorArea = rs.getString("floorarea");
				String rentprice = rs.getString("rentprice");
				String servicefee = rs.getString("servicefee");
				String brokeragefee = rs.getString("brokeragefee");
				System.out.println("//" + "buildingname" + "///" + "createdDate" + "///" + "address" + "///"
						+ "managerName" + "///" + "managerNum" + "///" + "floorArea" + "///" + "rentprice" + "///"
						+ "servicefee" + "///" + "brokeragefee");
				System.out.println("//" + buildingname + "///" + createdDate + "///" + address + "//" + managerName
						+ "///" + managerNum + "///" + floorArea + "///" + rentprice + "///" + servicefee + "///"
						+ brokeragefee);
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
