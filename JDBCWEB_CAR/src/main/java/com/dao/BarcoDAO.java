package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Barco;
import com.general.Database;
import com.general.IMetodos;

public class BarcoDAO implements IMetodos {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Database db = new Database();
	Barco b = null;
	String resultado = null;
	
	@Override
	public String guardar(Object ob) {
		//Añadimos un casteo del objeto que vamos a guardar
		b = (Barco) ob;
		String insert = "INSERT INTO BARCO VALUES (?,?,?,?,?)";
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(insert);
			ps.setInt(1,1);
			ps.setString(2,b.getNombre());
			ps.setInt(3,b.getNumAmarre());
			ps.setDouble(4,b.getCuota());
			ps.setInt(5,b.getIdSocio());
			
			int flag = ps.executeUpdate();
			
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha guardado un nuevo barco");
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
		b = (Barco) ob;
		String update = "UPDATE BARCO SET NOMBRE=?, NUME_AMARRE=?, CUOTA=?, ID_SOCIO=? WHERE ID_BARCO=?";
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(update);
			
			ps.setString(1,b.getNombre());
			ps.setInt(2,b.getNumAmarre());
			ps.setDouble(3,b.getCuota());
			ps.setInt(4,b.getIdSocio());
			ps.setInt(5,b.getIdBarco());
			
			int flag = ps.executeUpdate();
			
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha editado correctamente el barco");
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
		
		String delete = "DELETE FROM BARCO WHERE ID_BARCO=" + id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(delete);
			
			int flag = ps.executeUpdate();
			
			if (flag>0) {
				resultado = "1";
				System.out.println("Se ha eliminado correctamente el barco");
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
		
		String query = "SELECT * FROM BARCO WHERE ID_BARCO=" + id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				 b = new Barco(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	@Override
	public List<Barco> mostrar() {
		
		String query = "SELECT * FROM BARCO";
		
		List<Barco> alumnos = new ArrayList<Barco>();
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(),db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				b = new Barco(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5));
				alumnos.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alumnos;
	}

}
