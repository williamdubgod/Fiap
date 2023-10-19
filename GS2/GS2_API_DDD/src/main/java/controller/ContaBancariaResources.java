package controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import dao.ContaBancariaDao;
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
import model.ContaBancaria;

@Path("ContaBancaria")
public class ContaBancariaResources {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		try {
			
			List<ContaBancaria> retorno = ContaBancariaDao.getAll();
			
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
	public Response insert(ContaBancaria contaBancaria) {
		
		ContaBancaria resp = null;
		try {
			resp = ContaBancariaDao.insert(contaBancaria);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final URI contaBancariaURI = UriBuilder.fromResource(ContaBancariaResources.class).path("ContaBancaria/{id}").build(resp.getId());
		
		ResponseBuilder response = Response.created(contaBancariaURI);
		
		response.entity(resp);
		return response.build();
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") String id) {
		
		try {
			if(ContaBancariaDao.delete(id)) {
				ResponseBuilder response = Response.noContent();
				return response.build();
			}else {
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
	public Response update(ContaBancaria contaBancaria) {
		try {
			
			ContaBancaria response = ContaBancariaDao.update(contaBancaria);
			
			return Response.ok(response).build();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
