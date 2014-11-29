package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.rest.dao.FeedBackDAO;
import com.rest.model.Feedback;

@Path(value = "/feedback")
public class FeedbackService {
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void addProduct(final Feedback feedback) {
		FeedBackDAO feedBackDAO = new FeedBackDAO();
		feedBackDAO.addFeedback(feedback);
	}
}
