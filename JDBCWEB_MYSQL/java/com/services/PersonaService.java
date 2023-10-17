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

import com.dao.PersonaDAO;
import com.entity.Persona;
import com.general.Status;

@Path("persona")
public class PersonaService {

	PersonaDAO dao = null;

	@POST
	@Path("insertar")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Status insertar(Persona persona) {

		Status s = new Status();
		s.setOb(persona);
		dao = new PersonaDAO();
		String response = dao.insertar(persona);

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
	public List<Persona> seleccionar() {
		dao = new PersonaDAO();
		return dao.seleccionar();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("editar")
	public Status editar(Persona persona) {
		Status s = new Status();
		s.setOb(persona);
		dao = new PersonaDAO();
		String response = dao.editar(persona);

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
	public Status eliminar(@PathParam("id") int id) {
		Status s = new Status();
		dao = new PersonaDAO();
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

}
