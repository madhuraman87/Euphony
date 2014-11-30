package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void updateProduct(final Feedback feedback) {
		FeedBackDAO feedBackDAO = new FeedBackDAO();
		feedBackDAO.updateFeedback(feedback);
	}

	@GET
	@Path("/all/{userid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public FeedbackView getAllFeedback(@PathParam("userid") int userid) {
		FeedBackDAO feedBackDAO = new FeedBackDAO();
		return feedBackDAO.getAllFeedback(userid);
	}
	
	@GET
	@Path("/getfeedback/{userid}/{trackid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Feedback getFeedback(@PathParam("userid") int userid,@PathParam("trackid") int trackid) {
		FeedBackDAO feedBackDAO = new FeedBackDAO();
		return feedBackDAO.getFeedback(userid, trackid);
	}
}
