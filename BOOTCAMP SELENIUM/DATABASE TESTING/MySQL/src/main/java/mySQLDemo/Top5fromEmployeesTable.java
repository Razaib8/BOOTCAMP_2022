package mySQLDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Top5fromEmployeesTable {

	@Test
	public void dbConnection() throws SQLException, ClassNotFoundException {
		
		//Setting class/ Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc:mysql://localhost:3306/myschema?serverTimezone=UTC
		
		//create a connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?serverTimezone=UTC","root","Nylasf88");
		
		//create statement/Query
		Statement stmt =con.createStatement();
		
		String s= "SELECT * FROM employee.employees limit 5"; 
		
		//Execute statement/Query
		ResultSet rset = stmt.executeQuery(s);
		
		System.err.println("employee_id" +"\t"+ "first_name" +"\t"+ "last_name" +"\t"+ 
		        "email" +"\t\t\t\t\t"+ "phone_number" +"\t\t"+ "hire_date" +"\t\t"+ "job_id" +"\t\t"+ "salary" +"\t\t"+ 
				"manager_id" +"\t\t"+ "department_id");
		
		while (rset.next()) {
			System.out.println(rset.getString("employee_id") +"\t\t"+ 
		            rset.getString("first_name") +"\t\t"+ 
					rset.getString("last_name") +"\t\t"+ 
		            rset.getString("email") +"\t\t"+ 
					rset.getString("phone_number") +"\t\t"+ 
		            rset.getString("hire_date") +"\t\t"+ 
					rset.getString("job_id") +"\t\t"+ 
		            rset.getString("salary") +"\t\t"+ 
					rset.getString("manager_id") +"\t\t"+ 
		            rset.getString("department_id"));
		}
		
		//close Connection
		con.close(); 
		
		System.out.println("Query executed.....");

	}

}
