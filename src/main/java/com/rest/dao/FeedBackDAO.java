package com.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rest.model.Feedback;
import com.rest.model.FeedbackView;

public class FeedBackDAO {
	private static final String ADD_FEEDBACK = "insert into feedback (userid,trackid,score) values (?,?,?)";
	private static final String GET_FEEDBACK = "select userid,trackid,score from feedback where userid=? and trackid=?";
	private static final String GET_ALL_FEEDBACK = "select userid,trackid,score from feedback where userid = ?";	
	private static final String UPDATE_FEEDBACK = "update feedback set score = ? where userid= ? and trackid = ?";
	
	public void addFeedback(Feedback feedback) {
		System.out.println("Inside add: "+feedback.getScore());
		Connection conn = null;

		try {
			conn = DBOperation.getConnection();

			PreparedStatement prepStmt = conn.prepareStatement(ADD_FEEDBACK);

			prepStmt.setInt(1, feedback.getUserid());
			prepStmt.setInt(2, feedback.getTrackid());			
			prepStmt.setDouble(3, feedback.getScore());
			
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
	

	public void updateFeedback(Feedback feedback) {
		System.out.println("Inside update"+feedback.getScore());
		Connection conn = null;

		try {
			conn = DBOperation.getConnection();

			PreparedStatement prepStmt = conn.prepareStatement(UPDATE_FEEDBACK);

			prepStmt.setDouble(1, feedback.getScore());
			prepStmt.setInt(2, feedback.getUserid());
			prepStmt.setInt(3, feedback.getTrackid());				
			
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
	
	
	public Feedback getFeedback(int userid,int trackid){
		Connection conn = null;
		Feedback feedback = new Feedback();
		try {
			conn = DBOperation.getConnection();

			PreparedStatement prepStmt = conn.prepareStatement(GET_FEEDBACK);

			prepStmt.setInt(1, userid);
			prepStmt.setInt(2, trackid);			
					
			ResultSet rs = prepStmt.executeQuery();
			if (rs.next()) {
				feedback = setFeedbackBeanValues(rs);
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
		return feedback;
	}
	
	public FeedbackView getAllFeedback(int userid) {
		List<Feedback> feedbackList = new ArrayList<Feedback>();
		Connection conn = null;
		try {
			//
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(GET_ALL_FEEDBACK);
			prepStmt.setInt(1, userid);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				feedbackList.add(setFeedbackBeanValues(rs));
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
		return new FeedbackView(feedbackList);
	}

	public Feedback setFeedbackBeanValues(ResultSet rs) throws SQLException {

		Feedback feedback = new Feedback();
		feedback.setUserid(rs.getInt(1));
		feedback.setTrackid(rs.getInt(2));
		feedback.setScore(rs.getDouble(3));
		return feedback;

	}
}
