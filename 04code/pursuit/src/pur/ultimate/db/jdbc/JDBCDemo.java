package pur.ultimate.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
	public static void main(String[] args) {
		new JDBCDemo().query();
	}
	
	
	public void query(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pursuit", "root", "123456");
			
			PreparedStatement preparedStatement = conn.prepareStatement("select  id,username,password from pursuit.userinfo");
			ResultSet  rs = preparedStatement.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject("id")+":"+rs.getObject("username")+":"+rs.getObject("password")+":");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
