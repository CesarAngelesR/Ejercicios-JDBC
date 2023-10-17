package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.BarcoDAO;
import com.entity.Barco;
import com.general.Status;

@Path("barco")
public class BarcosService {
	
	BarcoDAO dao = null;
	
	@POST 
	@Path("guardar") 
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Status guardar(Barco b) {

		Status s = new Status();
		s.setOb(b);
		dao = new BarcoDAO();
		String response = dao.guardar(b);

		if (response.equals("1")) {
			s.setMensaje("OK");
			s.setRespuesta(response);

		} else {
			s.setMensaje("Error");
			s.setRespuesta(response);
		}
		return s;
	}

	@GET
	@Path("mostrar")
	@Produces({ MediaType.APPLICATION_JSON }) 
	public List<Barco> mostrar() {
		dao = new BarcoDAO();
		return dao.mostrar();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("editar")

	public Status editar(Barco b) {
		Status s = new Status();
		s.setOb(b);
		dao = new BarcoDAO();
		String response = dao.editar(b);

		if (response.equals("1")) {
			s.setMensaje("OK");
			s.setRespuesta(response);

		} else {
			s.setMensaje("Error");
			s.setRespuesta(response);
		}
		return s;
	}

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("eliminar/{id}")
	public Status eliminar(@PathParam ("id")int id) {
		Status s = new Status();
		dao = new BarcoDAO();
		String response = dao.eliminar(id);

		if (response.equals("1")) {
			s.setMensaje("OK");
			s.setRespuesta(response);

		} else {
			s.setMensaje("Error");
			s.setRespuesta(response);
		}
		return s;
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("buscar/{id}")
	public Barco buscar(@PathParam("id")int id) {
		dao = new BarcoDAO();
		return (Barco) dao.buscar(id);
	}

}
