package com.rest.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.rest.dao.UserDAO;
import com.rest.model.User;
import com.rest.model.UserView;

@Path(value = "/user")
public class UserService {
	
	@POST
	@Path("/signin")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public UserView login(@Context HttpServletRequest request,final User user) {
		UserDAO userDAO = new UserDAO();	
		UserView userView =  userDAO.validateUser(user);
		request.getSession().setAttribute("user", userView);		
		return userView;
	}
	
	@POST
	@Path("/signup")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public UserView addUser(@Context HttpServletRequest request,final User user) {
		UserDAO userDAO = new UserDAO();	
		UserView userView = userDAO.addUser(user);
		request.getSession().setAttribute("user", userView);		
		return userView;
	}
}
