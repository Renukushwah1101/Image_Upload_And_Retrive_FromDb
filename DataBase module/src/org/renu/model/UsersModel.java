package org.renu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.renu.entity.User;

public class UsersModel {
	public List<User> listUser(DataSource dataSource)
	{
		List<User> listUser=new ArrayList<>();
			Connection connect=null;
			 Statement stmt=null;
			 ResultSet rs=null;
			 try {
			     connect= dataSource.getConnection();
			     String query="SELECT * FROM users;";
			     stmt=connect.createStatement();
			     System.out.println("Connection created");
			     rs=stmt.executeQuery(query);
			     while(rs.next())
			     {
			    	listUser.add(new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("email")));
			     }
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
			 return listUser;
			 
	}

	public void addUser(DataSource dataSource,User newUser) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=dataSource.getConnection();
			String username = newUser.getUser_name();
			String email=newUser.getEmail();
			System.out.println("before insert");
			String query="insert into users(user_name,email) values(?,?)";
			statement=connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			System.out.println("After insert");
 statement.execute();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		/*finally
		{
			
			try {
				connect.close();
				statement.close();
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}

	public void updateUser(DataSource dataSource, User updatedUser) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=dataSource.getConnection();
			int userId=updatedUser.getUser_id();
			String username = updatedUser.getUser_name();
			String email=updatedUser.getEmail();
			System.out.println("before insert");
			String query="update users set user_name=?,email = ? where user_id=?";     
			statement=connect.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3,userId);
			System.out.println("After insert");
             statement.execute();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}

	public void deleteUser(DataSource dataSource,int userId) {
		Connection connect=null;
		PreparedStatement statement=null;
		try {
			connect=dataSource.getConnection();
			
			String query="delete from users where user_id=? ";  
			statement=connect.prepareStatement(query);
			System.out.println("from deleted operation");
			statement.setInt(1, userId);
             statement.execute();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
		
		
		
	}
