package com.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dao.AlbumDAO;
import com.rest.model.Album;
import com.rest.model.AlbumView;

@Path(value = "/album")
public class AlbumService {
	
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_JSON })
	public AlbumView getAllAlbums() {
		AlbumDAO  albumDAO = new AlbumDAO();
		return albumDAO.getAllAlbum();		
	}
	
	@GET
	@Path("/getalbum/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Album getAlbumById(@PathParam("id") int id) {
		AlbumDAO  albumDAO = new AlbumDAO();
		return albumDAO.getAlbumById(id);
	}
}
