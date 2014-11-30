package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dao.FeedBackDAO;
import com.rest.model.Feedback;
import com.rest.model.FeedbackView;

@Path(value = "/feedback")
public class FeedbackService {
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void addProduct(final Feedback feedback) {
		FeedBackDAO feedBackDAO = new FeedBackDAO();
		feedBackDAO.addFeedback(feedback);
	}
	

	/*@GET
	@Path("/allfeedbacks")
	@Produces({ MediaType.APPLICATION_JSON })
	public FeedbackView getAllFeedback() {
		FeedBackDAO feedBackDAO = new FeedBackDAO();
	}*/
}
