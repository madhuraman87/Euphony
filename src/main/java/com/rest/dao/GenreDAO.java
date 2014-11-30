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

import com.rest.model.Genre;

public class GenreDAO {

	private static final String tableName = "genre";
	private static final String INSERT_GENRE = "INSERT INTO " + tableName
			+ " (genreid) values (?)";
	private static final String GET_ALL_GENRE = "select * From " + tableName;
	private static final String File_Path = "C:/euphonyDataSet/track2/genreData2.txt";

	public void insertGenre() {
		Connection conn = null;
		try {
			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(File_Path));
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

	public List<Genre> getAllGenre() {
		List<Genre> genreList = new ArrayList<Genre>();
		Connection conn = null;
		try {
			//
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(GET_ALL_GENRE);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				genreList.add(setGenreBeanValues(rs));
			}

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
		return genreList;
	}

	public Genre setGenreBeanValues(ResultSet rs) {
		try {
			if (rs.next()) {
				Genre genre = new Genre();
				genre.setGenreid(rs.getInt(1));
				return genre;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) throws IOException {
		GenreDAO genreDAO = new GenreDAO();
		genreDAO.insertGenre();
	}
}
