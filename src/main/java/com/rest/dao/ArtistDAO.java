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

import com.rest.model.Artist;

public class ArtistDAO {

	private static final String tableName = "artist";
	private static final String INSERT_ARTIST = "INSERT INTO " + tableName
			+ " (artistid) values (?)";
	private static final String GET_ALL_ARTIST = "select * From " + tableName;
	private static final String File_Path = "C:/euphonyDataSet/track2/artistData2.txt";

	public void insertArtist() {
		Connection conn = null;
		try {
			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(File_Path));
			String line;
			while ((line = br.readLine()) != null) {

				PreparedStatement prepStmt = conn
						.prepareStatement(INSERT_ARTIST);
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

	public List<Artist> getAllArtist() {
		List<Artist> artistList = new ArrayList<Artist>();
		Connection conn = null;
		try {
			//
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(GET_ALL_ARTIST);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				artistList.add(setArtistBeanValues(rs));
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
		return artistList;
	}

	public Artist setArtistBeanValues(ResultSet rs) {
		try {
			if (rs.next()) {
				Artist artist = new Artist();
				artist.setArtistid(rs.getInt(1));
				return artist;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) throws IOException {
		ArtistDAO artistDAO = new ArtistDAO();
		artistDAO.insertArtist();
	}
}
