package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Createdatabase {
	public static Connection dbConn=null;
	static String dbURL = "jdbc:sqlserver://localhost;DatabaseName=�������ݿ�";
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
				System.out.println("����master���ݿ�ɹ�");
				statement = dbConn.prepareStatement("create database �������ݿ�");
				statement.executeUpdate();
				System.out.println("�������ݿ�ɹ�");
				dbConn = DriverManager.getConnection("jdbc:sqlserver://localhost;DatabaseName=�������ݿ�", name, passwd);
				System.out.println("�������ݿ�ɹ�");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("������");
			}
		}
        //2.����
	}
}