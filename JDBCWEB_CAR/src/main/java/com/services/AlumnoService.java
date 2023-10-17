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

import com.dao.AlumnoDAO;
import com.dto.ObjetoDTO;
import com.entity.Alumno;
import com.general.Status;

@Path("alumno") // Esta anotacion nos permite crear una parte del endpoint o URL para la
				// peticion
//y se indica en el nombre de la clase
public class AlumnoService {

	// La capa de servicio (controlador) es la que establece la comunicacion web y
	// da salida o entrada a los datos
	// que nos permite exponer la funcionalida del backend

	// traemos una instancia del DAO

	AlumnoDAO dao = null;

	@POST // Verbo HTTP para la creacion de nuevos recursos
	@Path("guardar") // Esta seria la parte final del endpoint (alumno/guardar)
	@Consumes({ MediaType.APPLICATION_JSON }) // El formato en el que se recibe informacion
	@Produces({ MediaType.APPLICATION_JSON }) // Formato en el que se devuelve o responde la informacion
	// Ejemplo de como queda la url o endpoint para este metodo
	// http://localhost:8090/JDBCWEB_CAR/JDBCWEB_CAR/alumno/guardar
	public Status guardar(Alumno a) {

		// vamos a responder al frente con nuestro objeto status
		// Que status tiene que responder
		Status s = new Status();
		s.setOb(a);// Este objeto va a ser el que se va a responder en la peticion
		dao = new AlumnoDAO();// Llamamos a nuestro DAO para inicializarlo
		String response = dao.guardar(a);// guardo el valor de las respuesra del metodo dao.guardar
		// para realizar una validacion

		if (response.equals("1")) {
			s.setMensaje("OK");
			s.setRespuesta(response);

		} else {
			s.setMensaje("Error");
			s.setRespuesta(response);
		}
		return s;
	}

	@GET // verbo http para obtener recursos
	@Path("mostrar")
	@Produces({ MediaType.APPLICATION_JSON }) // Formato en el que se devuelve o responde la informacion
	// Ejemplo de como queda la url o endpoint para este metodo
	// http://localhost:8090/JDBCWEB_CAR/JDBCWEB_CAR/alumno/mostrar
	public List<Alumno> mostrar() {
		dao = new AlumnoDAO();
		return dao.mostrar();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON }) // El formato en el que se recibe informacion
	@Produces({ MediaType.APPLICATION_JSON }) // Formato en el que se devuelve o responde la informacion
	@Path("editar")
	// http://localhost:8090/JDBCWEB_CAR/JDBCWEB_CAR/alumno/editar
	public Status editar(Alumno a) {
		Status s = new Status();
		s.setOb(a);
		dao = new AlumnoDAO();// Llamamos a nuestro DAO para inicializarlo
		String response = dao.editar(a);// guardo el valor de las respuesra del metodo dao.guardar
		// para realizar una validacion

		if (response.equals("1")) {
			s.setMensaje("OK");
			s.setRespuesta(response);

		} else {
			s.setMensaje("Error");
			s.setRespuesta(response);
		}
		return s;
	}
	// http://localhost:8090/JDBCWEB_CAR/JDBCWEB_CAR/alumno/eliminar/id
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("eliminar/{id}")
	public Status eliminar(@PathParam ("id")int id) {
		Status s = new Status();
		dao = new AlumnoDAO();// Llamamos a nuestro DAO para inicializarlo
		String response = dao.eliminar(id);// guardo el valor de las respuesra del metodo dao.guardar
		// para realizar una validacion

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
	// http://localhost:8090/JDBCWEB_CAR/JDBCWEB_CAR/alumno/buscar/id
	public Alumno buscar(@PathParam("id")int id) {
		dao = new AlumnoDAO();
		return (Alumno)dao.buscar(id);
	}
	
	@GET //
	@Path("detalles")
	@Produces({ MediaType.APPLICATION_JSON }) 
	public List<ObjetoDTO> getDetalles() {
		dao = new AlumnoDAO();
		return dao.getDetalles();
	}
	
}

