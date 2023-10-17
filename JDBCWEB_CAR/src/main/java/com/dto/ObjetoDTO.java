package com.dto;

public class ObjetoDTO {
	
	//Vamo a modelar un objeto que no exite como tal en nuestras
	//base de datos pero que nos servira para transferir o transportar dichos
	//datos (Data Transfer Object)
	
	private int idAlumno;
	private String alumno;
	private String carrera;
	private String tutor;
	
	public ObjetoDTO() {}

	public ObjetoDTO(int idAlumno, String alumno, String carrera, String tutor) {
		this.idAlumno = idAlumno;
		this.alumno = alumno;
		this.carrera = carrera;
		this.tutor = tutor;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "ObjetoDTO [idAlumno=" + idAlumno + ", alumno=" + alumno + ", carrera=" + carrera + ", tutor=" + tutor
				+ "]";
	}
}
