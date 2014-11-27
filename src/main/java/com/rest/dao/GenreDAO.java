package com.rest.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenreDAO {

	private static final String tableName = "genre";
	private static final String INSERT_GENRE = "INSERT INTO " + tableName	+ " (genreid) values (?)";

	public void insertGenre() {
		Connection conn = null;
		try {
			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(
					"C:/euphonyDataSet/track1/genreData1.txt"));
			String line;
			while ((line = br.readLine()) != null) {

				PreparedStatement prepStmt = conn
						.prepareStatement(INSERT_GENRE);
				prepStmt.setInt(1, Integer.valueOf(line));
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
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.insertGenre();
	}
}
