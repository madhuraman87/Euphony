package com.rest.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecommendationDAO {
	private static final String tableName = "usercommendation";
	private static final String tableName1 = "itemrecommendation";
	private static final String INSERT_URECOMMENDATION = "INSERT INTO " + tableName + " (userid,trackid,score) values (?,?,?)";
	private static final String INSERT_IRECOMMENDATION = "INSERT INTO " + tableName1 + " (userid,trackid,score) values (?,?,?)";
	private static final String File_Path = "/home/madhuajeeth/Desktop/CMPE282/Group Proj/data/user-user_Result.csv";
	
	public void insertuserrecommend() {
		Connection conn = null;
		try {

			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(File_Path));
			String line;

			while ((line = br.readLine()) != null) {
				//StringBuffer sb = new StringBuffer();
				String[] values = line.split("\\,", -1);
				PreparedStatement prepStmt = conn.prepareStatement(INSERT_URECOMMENDATION);

				prepStmt.setInt(1, Integer.valueOf(values[0]));
				prepStmt.setInt(2, Integer.valueOf(values[1]));
				prepStmt.setDouble(3, Double.valueOf(values[2]));
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
	
	public void insertitemrecommend() {
		Connection conn = null;
		try {

			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(File_Path));
			String line;

			while ((line = br.readLine()) != null) {
				//StringBuffer sb = new StringBuffer();
				String[] values = line.split("\\,", -1);
				PreparedStatement prepStmt = conn.prepareStatement(INSERT_IRECOMMENDATION);

				prepStmt.setInt(1, Integer.valueOf(values[0]));
				prepStmt.setInt(2, Integer.valueOf(values[1]));
				prepStmt.setDouble(3, Double.valueOf(values[2]));
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

	public static void main(String args[]) throws IOException {
		RecommendationDAO userrecommendDAO = new RecommendationDAO();
		userrecommendDAO.insertuserrecommend();
	}

}




