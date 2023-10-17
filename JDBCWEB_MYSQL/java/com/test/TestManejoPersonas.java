package com.test;

import java.util.List;

import com.dao.PersonaDAO;
import com.entity.Persona;


public class TestManejoPersonas {

	public static void main(String[] args) {
		
		PersonaDAO personaDao = new PersonaDAO();	
		
		//Insertar nueva persona
		/*Persona persona1 = new Persona("Cesar", "Angeles", "gdelosangeles@mail.com", "789522987");
		personaDao.insertar(persona1);
		//Editar nueva persona
		//Persona persona1 = new Persona(5,"Cesar", "Angeles", "gdelosangeles@mail.com", "773456987");
		//personaDao.editar(persona1);*/
		
		//Eliminar persona
		
		//Persona persona1 = new Persona(8);
		//personaDao.eliminar(persona1);
		
		List<Persona> personas = personaDao.seleccionar();
		personas.forEach(persona -> {
		System.out.println("Persona= " + persona);
		});
		
		//for(Persona persona : personas) {
			//System.out.println("Persona= " + persona);
		//}		
	}
}
