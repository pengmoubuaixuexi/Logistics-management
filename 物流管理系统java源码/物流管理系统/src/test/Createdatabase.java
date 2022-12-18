package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Createdatabase {
	public static Connection dbConn=null;
	static String dbURL = "jdbc:sqlserver://localhost;DatabaseName=测试数据库";
    static String name = "sa";
    static String passwd = "123";
    public ArrayList<String> bookInfo = new ArrayList<>();
    public static PreparedStatement statement = null;
    public ResultSet result = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dbConn = DriverManager.getConnection(dbURL, name, passwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				dbConn = DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=master", name, passwd);
				System.out.println("连接master数据库成功");
				statement = dbConn.prepareStatement("create database 测试数据库");
				statement.executeUpdate();
				System.out.println("创建数据库成功");
				dbConn = DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=测试数据库", name, passwd);
				System.out.println("连接数据库成功");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("出错了");
			}
		}
        //2.连接
	}
}