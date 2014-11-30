package com.rest.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.rest.model.User;
import com.rest.model.UserView;


public class UserDAO {
	private static final String tableName = "user";
	private static final String INSERT_USER = "INSERT INTO " + tableName + " (userid, password) values (?,?)";
	private static final String LOGIN_QUERY = "SELECT userid, password FROM " + tableName + " where userid=? and password=?";
	private static final String File_Path = "C:/euphonyDataSet/track2/ratings2.csv";
	
	public UserView validateUser(User user){
		Connection conn=null;
		UserView userView = new UserView();
		User userResult = null;
		try {
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(LOGIN_QUERY);
			prepStmt.setInt(1, user.getUserid());
			prepStmt.setString(2, user.getPassword());
			ResultSet rs = prepStmt.executeQuery();				
			userResult = setUserBeanValues(rs);
			if(userResult != null){
				userView.setUser(userResult);
				String msg = "Welcome "+userResult.getUserid()+" !";
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
		try {			
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(INSERT_USER);
			prepStmt.setInt(1, user.getUserid());
			prepStmt.setString(2, user.getPassword());
			prepStmt.executeUpdate();					
			userView.setUser(user);
			userView.setMessage("User added successfully!!!");
		} catch(MySQLIntegrityConstraintViolationException ex){
			userView.setMessage("User with this userid alreday exists ! Please sign up with different userid !");
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
	
	public void insertUser() {
		Connection conn = null;
		try {
			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(File_Path));
			String line;
			while ((line = br.readLine()) != null) {
				PreparedStatement prepStmt = conn.prepareStatement(INSERT_USER);
				prepStmt.setInt(1, Integer.valueOf(line));
				prepStmt.setString(2, line);
				prepStmt.executeUpdate();
			}
			br.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
						if (conn != null && !conn.isClosed()) {
						conn.close();
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public User setUserBeanValues(ResultSet rs){
		try {
			if(rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt(1));	
				user.setPassword(rs.getString(2));
				return user;
			}				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[]) throws IOException {
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser();
	}
}
