package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
	public static void main(String args[]){
		Connection dbConn=null;
		String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Logistics_company";
	    String name = "sa";
	    String passwd = "123";
	    PreparedStatement statement = null;
	    ResultSet result = null;
	    try {
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2.Á¬½Ó
        dbConn = DriverManager.getConnection(dbURL, name, passwd);
        statement = dbConn.prepareStatement("insert into admin values('nidie','pengtao')");
        statement.execute();
        statement = dbConn.prepareStatement("select * from admin");
		result = statement.executeQuery();
		while(result.next()) {
			System.out.println(result.getString("adminId")+","+result.getString("password"));
		}
	    }catch(Exception  e) {
	    	e.printStackTrace();
	    }
	}
}
