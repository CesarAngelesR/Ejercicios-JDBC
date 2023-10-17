package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestMySqlJDBC {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(url,"root","NCae7884");
			Statement instruccion = conexion.createStatement();
			String sql="SELECT idPersona, nombre, apellido, email, telefono FROM persona";
			ResultSet resultado = instruccion.executeQuery(sql);
			while(resultado.next()) {
				System.out.print("Id Persona: " + resultado.getInt("idPersona"));
				System.out.print(", Nombre: " + resultado.getString("nombre"));
				System.out.print(", Apellido: " + resultado.getString("apellido"));
				System.out.print(", Email: " + resultado.getString("email"));
				System.out.print(", Telefono: " + resultado.getString("telefono"));
			}
			resultado.close();
			instruccion.close();
			conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace(System.out);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
	}

}
