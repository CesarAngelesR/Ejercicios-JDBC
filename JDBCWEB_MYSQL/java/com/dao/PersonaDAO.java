package com.dao;

import java.sql.*;
import java.util.*;

import com.entity.Persona;
import com.general.Metodos;

import static com.general.Database.*;


public class PersonaDAO implements Metodos{
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Persona persona = null;
	String resultado=null;
	
	String SQL_INSERT ="INSERT INTO persona(nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
	String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?,telefono=? WHERE idPersona=?";
	String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";
	String SQL_SELECT = "SELECT idPersona, nombre, apellido, email, telefono FROM persona";
	
	@Override
	public List<Persona> seleccionar() {
		List<Persona> personas = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = getConnection();
			stmt = con.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5));
				personas.add(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				close(rs);
				close(stmt);
				close(con);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return personas;
	}
	@Override
	public String insertar(Persona persona) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = getConnection();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			int flag = stmt.executeUpdate();
			
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha guardado una nueva persona");
			}else {
				resultado = "0";
				System.out.println("Hubo un error");
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}
		finally {
			try {
				close(stmt);
				close(con);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
			
		}
		return resultado;
	}
	@Override
	public String editar(Persona persona) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = getConnection();
			stmt = con.prepareStatement(SQL_UPDATE);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5, persona.getIdPersona());
			int flag = stmt.executeUpdate();
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha editado una nueva persona");
			}else {
				resultado = "0";
				System.out.println("Hubo un error");
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}
		finally {
			try {
				close(stmt);
				close(con);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
			
		}
		return resultado;
	}
	@Override
	public String eliminar(int id) {			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = getConnection();		
			stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, persona.getIdPersona());
			int flag = stmt.executeUpdate();
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha eliminado el registro");
			}else {
				resultado = "0";
				System.out.println("Hubo un error");
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		}
		finally {
			try {
				close(stmt);
				close(con);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return resultado;
	}
}
