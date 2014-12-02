package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dao.ShoppingCartDAO;
import com.rest.model.ShoppingCart;
import com.rest.model.ShoppingCartView;

@Path(value = "/shoppingcart")
public class ShoppingCartService {
	
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void addToCart(final ShoppingCart shoppingCart) {
		ShoppingCartDAO cartDAO = new ShoppingCartDAO();
		cartDAO.addToCart(shoppingCart);
	}
	
	
	@GET
	@Path("/allshoppingcartitems/{userid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ShoppingCartView getShoppingCart(@PathParam("userid")Integer userid) {
		ShoppingCartDAO cartDAO = new ShoppingCartDAO();
		return cartDAO.getAllItems(userid);
	}
	
	
}
