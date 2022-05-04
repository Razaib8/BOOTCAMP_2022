package mySQLDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Top5fromLocationsTable {

	@Test
	public void dbConnection() throws SQLException, ClassNotFoundException {
		
		//Setting class/ Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc:mysql://localhost:3306/myschema?serverTimezone=UTC
		
		//create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?serverTimezone=UTC","root","Nylasf88");
		
		//create statement/Query
		Statement stmt =con.createStatement();
		
		String s= "SELECT * FROM employee.locations limit 5"; 
		
		//Execute statement/Query
		ResultSet rset = stmt.executeQuery(s);
		
		System.err.println("location_id" +"\t"+ "street_address" +"\t\t"+ "postal_code" +"\t"+ 
		        "city" +"\t\t"+ "state_province" +"\t\t"+ "country_id");
		
		while (rset.next()) {
			System.out.println(rset.getString("location_id") +"\t\t"+ 
		            rset.getString("street_address") +"\t\t"+ 
					rset.getString("postal_code") +"\t\t"+ 
		            rset.getString("city") +"\t\t"+ 
					rset.getString("state_province") +"\t\t"+ 
		            rset.getString("country_id"));
		}
		
		//close Connection
		con.close(); 
		
		System.out.println("Query executed.....");

	}

}
