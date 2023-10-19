package controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import dao.RealizaDao;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import model.Realiza;

@Path("Realiza")
public class RealizaResources {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {

			List<Realiza> retorno = RealizaDao.getAll();

			ResponseBuilder response = Response.ok();

			response.entity(retorno);
			return response.build();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Realiza realiza) {

		Realiza resp = null;
		try {
			resp = RealizaDao.insert(realiza);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final URI realizaURI = UriBuilder.fromResource(RealizaResources.class).path("Realiza/{id}")
				.build(resp.getIdDoacao());

		ResponseBuilder response = Response.created(realizaURI);

		response.entity(resp);
		return response.build();

	}

	@DELETE
	@Path("/{id}-{id2}-{id3}-{id4}")
	public Response delete(@PathParam("id") String id, @PathParam("id") String id2, @PathParam("id") String id3,
			@PathParam("id") String id4) {

		try {
			if (RealizaDao.delete(id, id2, id3, id4)) {
				ResponseBuilder response = Response.noContent();
				return response.build();
			} else {
				ResponseBuilder response = Response.notModified();
				return response.build();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Realiza realiza) {
		try {
			
			Realiza response = RealizaDao.update(realiza);
			
			return Response.ok(response).build();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
