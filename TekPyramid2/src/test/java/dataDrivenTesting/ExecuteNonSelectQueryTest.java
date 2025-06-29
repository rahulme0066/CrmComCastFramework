package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {

	Driver driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		Statement stat = conn.createStatement();
		
		int result = stat.executeUpdate("insert into employees values('3','Shubham','QA','20000')");
		System.out.println(result);
	
	}

}
