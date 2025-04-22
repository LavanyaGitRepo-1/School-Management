package com.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Service {
	static Scanner sc =new Scanner(System.in);
	static String url = "jdbc:postgresql://localhost:5432/school management";
    static String user = "postgres";
    static String pwd = "123";
	private static Connection con;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int insert() {
		System.out.println("Enter student id");
		int id=sc.nextInt();
		System.out.println("Enter the name");
		String name=sc.next();
		System.out.println("Enter age");
		int age=sc.nextInt();
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter course");
		String course=sc.next();
		int no=0;
		String sql="INSERT into student values(?,?,?,?,?)";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3,age);
			pstm.setString(4, email);
			pstm.setString(5, course);
			no=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no;
	}
	//update data
	public int update() {
		System.out.println("Enter 1 to update name");
		System.out.println("Eneter 2 to update age");
		System.out.println("Eneter 3 to update email");
		System.out.println("Enter 4 to update course");
		System.out.println("Chooce your option");
		int n=sc.nextInt();
		int no=0;
		switch(n) {
		case 1:
		{
			String sql="UPDATE student set name=? where id=?";
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Enter name to update");
			String name=sc.next();
			System.out.println("Enter id to change the name");
			int id=sc.nextInt();
				try {
					pstm.setString(1, name);
					pstm.setInt(2, id);
					
					no=pstm.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
		}
		case 2:
		{
			String sql="UPDATE student set age=? where id=?";
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Enter age to update");
			int age=sc.nextInt();
			System.out.println("Enter id to change the name");
			int id=sc.nextInt();
				try {
					pstm.setInt(1, age);
					pstm.setInt(2, id);
					
					no=pstm.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
		}
		case 3:
		{
			String sql="UPDATE student set email=? where id=?";
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Enter mail to update");
			String email=sc.next();
			System.out.println("Enter id to change the name");
			int id=sc.nextInt();
				try {
					pstm.setString(1, email);
					pstm.setInt(2, id);
					
					no=pstm.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
		}
		case 4:
		{
			String sql="UPDATE student set course=? where id=?";
			PreparedStatement pstm = null;
			try {
				pstm = con.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Enter course to update");
			String course=sc.next();
			System.out.println("Enter id to change the name");
			int id=sc.nextInt();
				try {
					pstm.setString(1, course);
					pstm.setInt(2, id);
					
					no=pstm.executeUpdate();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				break;
		}
		}
		return no;
	}
//delete data
	public int delete() {
		String sql="DELETE from student where id=?";
		int no = 0;
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			System.out.println("Enter id to delete");
			int id=sc.nextInt();
			pstm.setInt(1, id);
			no=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return no;
	}
	//fetch data
	public void fetch()
	{
		int no=0;
		String sql="SELECT * from student";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				String email=rs.getString(4);
				String course=rs.getString(5);
				System.out.println("ID  -  "+id);
				System.out.println("NAME  -  "+name);
				System.out.println("AGE  -  "+age);
				System.out.println("EMAIL  -  "+email);
				System.out.println("COURSE  -  "+course);
				System.out.println("************************");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
