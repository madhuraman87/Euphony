package com.rest.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlbumDAO {
	private static final String tableName = "album";
	private static final String INSERT_ALBUM = "INSERT INTO " + tableName
			+ " (albumid,artistid,genreid) values (?,?,?)";
	private static final String GET_ALL_ALBUM = "select * From " + tableName;
	private static final String File_Path = "C:/euphonyDataSet/track1/albumData1.txt";

	public void insertAlbum() {
		Connection conn = null;
		try {
			
			conn = DBOperation.getConnection();
			BufferedReader br = new BufferedReader(new FileReader(File_Path));
			String line;
			
			while ((line = br.readLine()) != null) {
				StringBuffer sb = new StringBuffer();
				String[] values = line.split("\\|", -1);
				
				for(int i=2;i<values.length;i++){
					sb.append(values[i]);
					if(i < (values.length -1))
						sb.append(",");
				}
								
				PreparedStatement prepStmt = conn
						.prepareStatement(INSERT_ALBUM);
				
				prepStmt.setInt(1, Integer.valueOf(values[0]));
				prepStmt.setString(2, values[1]);
				if(sb.toString().equalsIgnoreCase(" ")){
					prepStmt.setNull(3, java.sql.Types.NULL);			
				}else{
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
	
	
	
	public static void main(String args[]) throws IOException {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.insertAlbum();
	}

}
