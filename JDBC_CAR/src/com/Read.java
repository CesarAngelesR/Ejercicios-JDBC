package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read {

	public static void main(String[] args) {
		//Establecer conexion a base e datos mediante JDBC
		//READ - Leer datos (Consulta de datos)
		
		Connection con = null;//conexion a base de datos
		//aun no le asignamos ningun valor a la conexion
		
		PreparedStatement ps = null;//Interpretar las sentencias sql precompiladas de la conexion d
		//a base de datos, (entrada de datos)
		
		ResultSet rs= null;//salida de datos
		
		String query ="SELECT * FROM ALUMNO";//Guardamos en una variable String
		//la sentencia SQL a ejecutarse
		
		try {//Intentar ejecutar el siguiente codigo
			Class.forName("oracle.jdbc.OracleDriver");
			//Buscar una clase dentro de un paquete
			//Inicializamos nuestra coneccion
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cangeles","admin");
			ps = con.prepareStatement(query);//Identifica o precompila la sentencia SQL
			rs = ps.executeQuery();//Ejecuta la sentencia SQL ya interpretada
			
			/*while (rs.next()) {//Miestras rs tenga columnas y filas por mostrar
				System.out.println(rs.getInt("ID_ALUMNO")
						+ " : " + rs.getString("NOMBRE") 
						+ " : " + rs.getDate("FECHA_NAC")
						+ " : " + rs.getString("GENERO") 
						+ " : " + rs.getString("GRADO")
						+ " : " + rs.getInt("STATUS"));
			}*/
			
			while (rs.next()) {//Miestras rs tenga columnas y filas por mostrar
				System.out.println(rs.getInt(1)
						+ " : " + rs.getString(2) 
						+ " : " + rs.getDate(3)
						+ " : " + rs.getString(4)
						+ " : " + rs.getString(5)
						+ " : " + rs.getInt(6));
			}
			
			
			
		} catch (Exception e) {
			System.out.println("No se pudo realizar la consulta");
			e.printStackTrace();
		}

	}

}
