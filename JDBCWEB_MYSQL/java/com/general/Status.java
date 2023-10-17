package com.general;

public class Status {
	
	private Object ob;
	private String mensaje;
	private String respuesta;
	
	public Status() {}

	public Status(Object ob, String mensaje, String respuesta) {
		this.ob = ob;
		this.mensaje = mensaje;
		this.respuesta = respuesta;
	}

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Status [ob=" + ob + ", mensaje=" + mensaje + ", respuesta=" + respuesta + "]";
	}
}