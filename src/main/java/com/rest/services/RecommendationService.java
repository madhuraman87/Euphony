package com.rest.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dao.RecommendationDAO;
import com.rest.model.ItemRecommendation;
import com.rest.model.PersonalizeRecommendation;
import com.rest.model.UserRecommendation;

@Path(value = "/recommendation")
public class RecommendationService {
	
	@GET
	@Path("/getAllItemRecommendation/{userid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ItemRecommendation> getAllItemRecommendation(@PathParam("userid") int userid) {
		RecommendationDAO  recommendationDAO = new RecommendationDAO();
		return recommendationDAO.getAllItemRecommendation(userid);
	}
	
	@GET
	@Path("/getAllUserRecommendation/{userid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<UserRecommendation> getAllUserRecommendation(@PathParam("userid") int userid) {
		RecommendationDAO  recommendationDAO = new RecommendationDAO();
		return recommendationDAO.getAllUserRecommendation(userid);
	}
	
	@GET
	@Path("/getAllPersonalizeRecommendation/{userid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PersonalizeRecommendation> getAllPersonalizeRecommendation(@PathParam("userid") int userid) {
		RecommendationDAO  recommendationDAO = new RecommendationDAO();
		return recommendationDAO.getAllPersonalizeRecommendation(userid);
	}
}
