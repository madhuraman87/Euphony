package com.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.rest.model.User;
import com.rest.model.UserView;


public class UserDAO {
	private static final String LOGIN_QUERY = "select * from user where email=? and password=?";
	private static final String INSERT_USER= "insert into user (fname,lname,email,password) values (?,?,?,?)";

	public UserView validateUser(User user){
		Connection conn=null;
		UserView userView = new UserView();
		User userResult = null;
		try {
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(LOGIN_QUERY);
			prepStmt.setString(1, user.getEmail());
			prepStmt.setString(2, user.getPassword());
			ResultSet rs = prepStmt.executeQuery();				
			userResult = setUserBeanValues(rs);
			if(userResult != null){
				java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());	
				//update the last login
				DBOperation.updateLastLogin(date,userResult.getUser_id());
				userView.setUser(userResult);
				String msg = "Welcome "+userResult.getFname()+" !";
				userView.setMessage(msg);				
			}else{
				userView.setMessage("Invalid User Name or password !");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userView;
	}
	
	public UserView addUser(User user){	
		UserView userView = new UserView();
		Connection conn = null;
		Long user_id;
		ResultSet rs;
		try {			
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(INSERT_USER);
			prepStmt.setString(1, user.getFname());
			prepStmt.setString(2, user.getLname());
			prepStmt.setString(3, user.getEmail());
			prepStmt.setString(4, user.getPassword());
			prepStmt.executeUpdate();					
			PreparedStatement prepStmt1 = conn.prepareStatement("select last_insert_id() from webstore.user");
			rs = prepStmt1.executeQuery();
			user_id = rs.getLong(1);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());	
			//update the last login
			DBOperation.updateLastLogin(date,user_id);
			user.setUser_id(user_id);
			user.setLast_login(date);
			user.setAdmin(false);
			userView.setUser(user);
		} catch(MySQLIntegrityConstraintViolationException ex){
			userView.setMessage("User with this email alreday exists ! Please sign up with different email !");
			return userView;
		}catch (Exception e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userView;
		
	}

	
	public User setUserBeanValues(ResultSet rs){
		try {
			if(rs.next()) {
				User user = new User();
				java.util.Date date = rs.getTimestamp("last_login");
				user.setUser_id(rs.getLong("user_id"));			
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setEmail(rs.getString("email"));				
				user.setPassword(rs.getString("password"));
				user.setLast_login(date);	
				if(rs.getInt("is_admin") == 0){
					user.setAdmin(false);
				}else{
					user.setAdmin(true);
				}
				return user;
			}				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
