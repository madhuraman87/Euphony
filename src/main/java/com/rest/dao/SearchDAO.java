package com.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rest.model.Search;
import com.rest.model.SearchView;

public class SearchDAO {
	
	private final String SEARCH_QUERY = "";
	
	public SearchView search(Search search){
		List<Search> searchList = new ArrayList<Search>();
		Connection conn = null;
		try {
			//
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(SEARCH_QUERY);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				searchList.add(setSearchBeanValues(rs));
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
		return new SearchView(searchList);
	}
	
	
	public Search setSearchBeanValues(ResultSet rs) {
		try {
			if (rs.next()) {
				Search search = new Search();
				search.setAlbumid(rs.getInt(1));
				search.setTrackid(rs.getInt(2));
				search.setArtistid(rs.getInt(3));
				search.setGenreid(rs.getString(4));
				return search;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
