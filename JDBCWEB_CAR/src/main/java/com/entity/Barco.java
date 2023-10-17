package com.entity;

public class Barco {
	private int idBarco;
	private String nombre;
	private int numAmarre;
	private double cuota;
	private int idSocio;
	private Barco() {}
	public Barco(int idBarco, String nombre, int numAmarre, double cuota, int idSocio) {
		this.idBarco = idBarco;
		this.nombre = nombre;
		this.numAmarre = numAmarre;
		this.cuota = cuota;
		this.idSocio = idSocio;
	}
	public int getIdBarco() {
		return idBarco;
	}
	public void setIdBarco(int idBarco) {
		this.idBarco = idBarco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumAmarre() {
		return numAmarre;
	}
	public void setNumAmarre(int numAmarre) {
		this.numAmarre = numAmarre;
	}
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	@Override
	public String toString() {
		return "Barco [idBarco=" + idBarco + ", nombre=" + nombre + ", numAmarre=" + numAmarre + ", cuota=" + cuota
				+ ", idSocio=" + idSocio + "]";
	}
	
	
}
