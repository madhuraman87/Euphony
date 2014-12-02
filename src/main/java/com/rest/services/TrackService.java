package com.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dao.ShoppingCartDAO;
import com.rest.dao.TrackDAO;
import com.rest.model.ShoppingCart;
import com.rest.model.Track;
import com.rest.model.TrackView;

@Path(value = "/track")
public class TrackService {
	
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public TrackView getAllTracks() {
		TrackDAO  trackDAO = new TrackDAO();
		return trackDAO.getAllTrack();		
	}
	
	
	@GET
	@Path("/gettrack/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Track getTrackById(@PathParam("id") int id) {
		TrackDAO  trackDAO = new TrackDAO();
		return trackDAO.getTrackById(id);
	}
	
	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void addSong(final Track track) {
		TrackDAO  trackDAO = new TrackDAO();
		trackDAO.addSong(track);
	}
}
