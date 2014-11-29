package com.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rest.model.Feedback;

public class FeedBackDAO {
	private static final String ADD_FEEDBACK = "insert into feedback (userid,albumid,trackid,artistid,score) values (?,?,?,?,?)";

	public void addFeedback(Feedback feedback) {

		Connection conn = null;

		try {
			conn = DBOperation.getConnection();

			PreparedStatement prepStmt = conn.prepareStatement(ADD_FEEDBACK);

			prepStmt.setInt(1, feedback.getUserid());

			if (feedback.getAlbumid() != null) {
				prepStmt.setString(2, feedback.getAlbumid());
			} else {
				prepStmt.setNull(2, java.sql.Types.NULL);
			}

			if (feedback.getTrackid() != null) {
				prepStmt.setString(3, feedback.getTrackid());
			} else {
				prepStmt.setNull(3, java.sql.Types.NULL);
			}

			if (feedback.getArtistid() != null) {
				prepStmt.setString(4, feedback.getArtistid());
			} else {
				prepStmt.setNull(4, java.sql.Types.NULL);
			}

			if (feedback.getScore() != 0) {
				prepStmt.setInt(5, feedback.getScore());
			} else {
				prepStmt.setNull(5, java.sql.Types.NULL);
			}

			prepStmt.executeUpdate();

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

}
