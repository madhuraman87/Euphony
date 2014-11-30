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

import com.rest.model.Album;
import com.rest.model.AlbumView;

public class AlbumDAO {
	private static final String tableName = "album";
	private static final String INSERT_ALBUM = "INSERT INTO " + tableName
			+ " (albumid,artistid,genreid) values (?,?,?)";
	private static final String GET_ALL_ALBUM = "select albumid,artistid,genreid From "
			+ tableName ;
	private static final String GET_ALBUM_BY_ID = GET_ALL_ALBUM
			+ " where albumid = ?";
	private static final String File_Path = "C:/euphonyDataSet/track2/albumData2.txt";

	public void insertAlbum() {
		Connection conn = null;
		try {

			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(File_Path));
			String line;

			while ((line = br.readLine()) != null) {
				StringBuffer sb = new StringBuffer();
				String[] values = line.split("\\|", -1);

				for (int i = 2; i < values.length; i++) {
					sb.append(values[i]);
					if (i < (values.length - 1))
						sb.append(",");
				}

				PreparedStatement prepStmt = conn
						.prepareStatement(INSERT_ALBUM);

				prepStmt.setInt(1, Integer.valueOf(values[0]));
				prepStmt.setString(2, values[1]);
				if (sb.toString().equalsIgnoreCase(" ")) {
					prepStmt.setNull(3, java.sql.Types.NULL);
				} else {
					prepStmt.setString(3, sb.toString());
				}
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

	public AlbumView getAllAlbum() {
		List<Album> albumList = new ArrayList<Album>();
		Connection conn = null;
		try {
			//
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(GET_ALL_ALBUM);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				albumList.add(setAlbumBeanValues(rs));
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
		return new AlbumView(albumList);
	}

	public Album setAlbumBeanValues(ResultSet rs)throws SQLException  {

		Album album = new Album();
		album.setAlbumid(rs.getInt(1));
		album.setArtist(rs.getString(2));
		album.setGenre(rs.getString(3));
		return album;

	}

	public Album getAlbumById(Integer albumid) {
		Album album = new Album();
		Connection conn = null;
		try {
			//
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(GET_ALBUM_BY_ID);
			prepStmt.setInt(1, albumid);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				album = setAlbumBeanValues(rs);
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
		return album;
	}

	public static void main(String args[]) throws IOException {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.insertAlbum();
	}

}
