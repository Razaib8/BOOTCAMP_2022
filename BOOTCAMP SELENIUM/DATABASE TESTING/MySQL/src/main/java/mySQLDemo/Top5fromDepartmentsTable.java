package mySQLDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Top5fromDepartmentsTable {

	@Test
	public void dbConnection() throws SQLException, ClassNotFoundException {
		
		//Setting class/ Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc:mysql://localhost:3306/myschema?serverTimezone=UTC
		
		//create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?serverTimezone=UTC","root","Nylasf88");
		
		//create statement/Query
		Statement stmt =con.createStatement();
	
		String s= "SELECT * FROM employee.departments limit 5"; 
		
		//Execute statement/Query
		ResultSet rset = stmt.executeQuery(s);
		
		System.err.println("department_id" +"\t"+ "department_name" +"\t\t"+ "location_id");
		
		while (rset.next()) {
			System.out.println(rset.getString("department_id") +"\t\t"+ 
		            rset.getString("department_name") +"\t\t"+ 
					rset.getString("location_id"));
		}
		
		//close Connection
		con.close();
		
		System.out.println("Query executed.....");

	}

}
