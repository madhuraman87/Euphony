package com.rest.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RecommendationDAO {
	private static final String userRecommendationTable = "usercommendation";
	private static final String itemRecommendationTable = "itemrecommendation";
	private static final String personalizeRecommendationTable = "personalrecommendation";
	private static final String INSERT_USER_RECOMMENDATION = "INSERT INTO "
			+ userRecommendationTable
			+ " (userid,trackid,score) values (?,?,?)";
	private static final String INSERT_ITEM_RECOMMENDATION = "INSERT INTO "
			+ itemRecommendationTable
			+ " (userid,trackid,score) values (?,?,?)";

	private static final String USER_File_Path = "C:/euphonyDataSet/track2/user-user_Result.csv";
	private static final String ITEM_File_Path = "C:/euphonyDataSet/track2/item_item_Result.txt";
	private static final String PERSONALIZE_File_Path = "C:/euphonyDataSet/track2/user-user_Result.csv";

	public void insertUserRecommend() {
		Connection conn = null;
		try {

			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(
					USER_File_Path));
			String line;

			while ((line = br.readLine()) != null) {
				// StringBuffer sb = new StringBuffer();
				String[] values = line.split("\\,", -1);
				PreparedStatement prepStmt = conn
						.prepareStatement(INSERT_USER_RECOMMENDATION);

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

	public void insertItemRecommend() {
		Connection conn = null;
		try {

			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(ITEM_File_Path));
			String line;
			
			while ((line = br.readLine()) != null) {
				String userid = null;
				String[] values = line.split("\\s+", -1);
				userid = values[0];
				String itemsString = values[1].substring(1,
						values[1].length() - 1);
				String itemValues[] = itemsString.split(",");
				for (String item : itemValues) {
					String trackid = item.substring(0, item.indexOf(":"));
					double score = Double.valueOf(item.substring(item.indexOf(":") + 1, item.length()));
					PreparedStatement prepStmt = conn.prepareStatement(INSERT_ITEM_RECOMMENDATION);
					prepStmt.setInt(1, Integer.valueOf(userid));
					prepStmt.setInt(2, Integer.valueOf(trackid));
					prepStmt.setDouble(3, score);
					prepStmt.executeUpdate();
				}

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
		RecommendationDAO recommendationDAO = new RecommendationDAO();

		recommendationDAO.insertItemRecommend();
		// userrecommendDAO.insertuserrecommend();
	}

}
