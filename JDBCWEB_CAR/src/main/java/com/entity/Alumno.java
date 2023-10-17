package com.entity;

import java.sql.Date;

public class Alumno {
	//En el paquete entity es donde vamos a tener mapeados nuestros objetos
	//de la base de datos (entidades-objetos existentes en una base de datos)
	
	//tenemos que crear nuestro objeto con las variables en las que vamos a recibir
	//informacion y tambien con las que vamos a guardarla
	
	private int idAlumno;
	private String nombre;
	private Date fechaNac;
	private String genero;
	private String grado;
	private int status;
	
	public Alumno() {}

	public Alumno(int idAlumno, String nombre, Date fechaNac, String genero, String grado, int status) {
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.grado = grado;
		this.status = status;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", genero=" + genero
				+ ", grado=" + grado + ", status=" + status + "]";
	}
}