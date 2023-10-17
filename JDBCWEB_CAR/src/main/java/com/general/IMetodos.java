package com.general;

import java.util.List;

public interface IMetodos {
	
	//Vamos a declarar las operaciones que se le van a instruir 
	//a la clase que se encargara de implementar dicha logica (DAO-Data Acces Objet)
	
	//Devolvemos un String y guardamos un objeto de la base de datos
	public String guardar(Object ob);
	//Devolvemos un String y editamos un objeto de la base de datos
	public String editar(Object ob);
	//Devolvemos un String y eliminamos un objeto de la base de datos por ID
	public String eliminar(int id);
	//Devolvemos un Objeto de la base de datos y los buscamos por ID
	public Object buscar(int id);
	//Devolvemos una Lista con todos los objetos de la tabla.
	public List mostrar();

}
