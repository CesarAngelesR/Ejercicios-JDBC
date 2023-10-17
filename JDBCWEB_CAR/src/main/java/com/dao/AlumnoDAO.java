package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.ObjetoDTO;
import com.entity.Alumno;
import com.general.Database;
import com.general.IMetodos;

public class AlumnoDAO implements IMetodos{
	
	//Esta clase se va a encargar de tener la logica de las operaciones
	//y transformar la informacion
	
	//Necesitamos a las interfases para realizar la conexion de datos.
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	Database db = new Database();
	
	Alumno a = null;
	String resultado = null;
	
	@Override
	public String guardar(Object ob) {
		//Añadimos un casteo del objeto que vamos a guardar
		a = (Alumno) ob;
		String insert = "INSERT INTO ALUMNO VALUES (?,?,?,?,?,?)";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(insert);
			ps.setInt(1,1);
			ps.setString(2,a.getNombre());
			ps.setDate(3,a.getFechaNac());
			ps.setString(4,a.getGenero());
			ps.setString(5,a.getGrado());
			ps.setInt(6,1);
			
			int flag = ps.executeUpdate();
			
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha guardado un nuevo alumno");
			}else {
				resultado = "0";
				System.out.println("Hubo un error");
			}
			
		} catch (Exception e) {
			resultado = e.getMessage();
		}
		
		return resultado;
	}
	@Override
	public String editar(Object ob) {
		a = (Alumno) ob;
		String update = "UPDATE ALUMNO SET NOMBRE=?, FECHA_NAC=?, GENERO=?, GRADO=? WHERE ID_ALUMNO=?";
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(update);
			
			ps.setString(1,a.getNombre());
			ps.setDate(2,a.getFechaNac());
			ps.setString(3,a.getGenero());
			ps.setString(4,a.getGrado());
			ps.setInt(5,a.getIdAlumno());
			
			int flag = ps.executeUpdate();
			
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha editado correctamente el alumno");
			}else {
				resultado = "0";
				System.out.println("Hubo un error");
			}
			
		} catch (Exception e) {
			resultado = e.getMessage();
		}
		
		return resultado;
	}
	@Override
	public String eliminar(int id) {
		
		String delete = "DELETE FROM ALUMNO WHERE ID_ALUMNO=" + id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(delete);
			
			int flag = ps.executeUpdate();
			
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha eliminado correctamente el alumno");
			}else {
				resultado = "0";
				System.out.println("Hubo un error");
			}
			
		} catch (Exception e) {
			resultado = e.getMessage();
		}
		return resultado;
	}
	@Override
	public Object buscar(int id) {
		
		String query = "SELECT * FROM ALUMNO WHERE ID_ALUMNO=" + id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				 a = new Alumno(rs.getInt(1), rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}
	@Override
	public List<Alumno> mostrar() {
		
		String query = "SELECT * FROM ALUMNO";
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				 a = new Alumno(rs.getInt(1), rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				 alumnos.add(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alumnos;
	}
	//Pegamos la consulta del objeto que no existe en la base de datos ya que se
	//compone de varias tablas
	public List<ObjetoDTO> getDetalles(){
		String query="SELECT A.ID_ALUMNO, A.NOMBRE AS ALUMNO, C.NOMBRE AS CARRERA, T.NOMBRE AS TUTOR FROM ALUMNO A " + 
				"INNER JOIN CARRERAS_ALUMNOS CA " + 
				"ON A.ID_ALUMNO=CA.ID_CA " + 
				"INNER JOIN CARRERAS C " + 
				"ON C.ID_CARRERA=CA.ID_ALUMNO " + 
				"INNER JOIN ALUMNOS_TUTORES AT " + 
				"ON A.ID_ALUMNO=AT.ID_ALUMNO " + 
				"INNER JOIN TUTORES T " + 
				"ON T.ID_TUTOR=AT.ID_TUTOR";
		
		List<ObjetoDTO> detalles = new ArrayList<ObjetoDTO>();
		ObjetoDTO fila=null;
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				 fila = new ObjetoDTO(rs.getInt("ID_ALUMNO"), 
						 rs.getString("ALUMNO"),
						 rs.getString("CARRERA"),
						 rs.getString("TUTOR"));
				 detalles.add(fila);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detalles;
	}
}
