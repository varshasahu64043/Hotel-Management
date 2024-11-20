package System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	Connection c;
	Statement s;
	public Conn() {
	try{
		Class.forName("com.mysql.jdbc.Driver");		
 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2se","root","root");
		System.out.println("connection is created");
		 s=c.createStatement();
	}
	catch(Exception e){
		e.printStackTrace();
}
}
}
