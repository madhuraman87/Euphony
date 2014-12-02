package com.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rest.model.Feedback;
import com.rest.model.FeedbackView;
import com.rest.model.ShoppingCart;
import com.rest.model.ShoppingCartView;

public class ShoppingCartDAO {

	public static final String tableName = "shoppingcart";
	private static final String ADD_TO_CART = "insert into shoppingcart (userid,trackid,albumid) values (?,?,?)";
	private static final String GET_ALL_ITEMS = "select userid,trackid,albumid from shoppingcart where userid = ?" ;
	public void addToCart(ShoppingCart shoppingCart) {
		
		Connection conn = null;

		try {
			conn = DBOperation.getConnection();

			PreparedStatement prepStmt = conn.prepareStatement(ADD_TO_CART);

			prepStmt.setInt(1, shoppingCart.getUserid());
			prepStmt.setInt(2, shoppingCart.getTrackid());			
			prepStmt.setInt(3, shoppingCart.getAlbumid());
			
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
	
	public ShoppingCartView getAllItems(int userid) {
		List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
		Connection conn = null;
		try {
			//
			conn = DBOperation.getConnection();
			PreparedStatement prepStmt = conn.prepareStatement(GET_ALL_ITEMS);
			prepStmt.setInt(1, userid);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				shoppingCartList.add(setShoppingCartBeanValues(rs));
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
		return new ShoppingCartView(shoppingCartList);
	}

	public ShoppingCart setShoppingCartBeanValues(ResultSet rs) throws SQLException {

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUserid(rs.getInt(1));
		shoppingCart.setTrackid(rs.getInt(2));
		shoppingCart.setAlbumid(rs.getInt(3));
		return shoppingCart;

	}
}