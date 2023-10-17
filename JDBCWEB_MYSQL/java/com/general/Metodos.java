package com.general;

import java.util.List;

import com.entity.Persona;

public interface Metodos {
	
	public List<Persona> seleccionar();
	
	public String insertar(Persona persona);

	public String editar(Persona persona);

	public String eliminar(int id);


	

}

