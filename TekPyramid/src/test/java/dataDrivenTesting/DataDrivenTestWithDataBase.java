package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataDrivenTestWithDataBase {

	public static void main(String[] args) throws SQLException {
		
		Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		Statement stat = conn.createStatement();
		
		ResultSet resultSet = stat.executeQuery("select * from employees");
		
		while(resultSet.next()) {
			System.out.print("  "+ resultSet.getString(1));
			System.out.print("  "+resultSet.getString(2));
			System.out.print("  "+resultSet.getString(3));
			System.out.print("  "+resultSet.getString(4));

			System.out.println();
			


		}
		conn.close();

	}

}
