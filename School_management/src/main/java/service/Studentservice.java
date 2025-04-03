package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Student;

public class Studentservice {
private static String url="jdbc:postgresql://localhost:5432/school";
private static String user="postgres";
private static String pswd="123";
private static Connection con;
	
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
			
			con=DriverManager.getConnection(url,user,pswd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int save(Student st1)
	{
		
		int res=0;

		int id=st1.getAge();
		String name=st1.getName();
		int age=st1.getAge();
		String gender=st1.getGender();
	String sql="INSERT into school values(?,?,?,?)";
		
	try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.setString(2,name);
		pstm.setInt(3, age);
		pstm.setString(4, gender);

		
		res=pstm.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res;
	
	}
	
	
}
