package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Create {

	public static void main(String[] args) {
		// CREATE - Insercion de datos o nuevos recursos.
		
		Connection con = null;//conexion a base de datos
		//aun no le asignamos ningun valor a la conexion
		
		PreparedStatement ps = null;//Interpretar las sentencias sql precompiladas de la conexion d
		//a base de datos, (entrada de datos)
		
		//Ahora en nuestra sentencia indicamos las columnas a insertas,
		//señalando unicamente el campo con un "?"
		String insert = "INSERT INTO ALUMNO VALUES(?,?,?,?,?,?)";//Guardamos en una variable String
		//la sentencia SQL a ejecutarse
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cangeles","admin");
			ps = con.prepareStatement(insert);
			
			//Asignamos valors a inservat a la base de datos
			ps.setInt(1,1);//Vamos indicando el numero de columna y el valor correspondiente a insertar
			//en dicha columna. Este valor es ID y recordemos que la base de datos tiene asignado un 
			//una secuencia y un disparador, en este caso ponemos el numero por requisito.
			ps.setString(2,"EDUARDO");
			ps.setString(3, "20/04/1990");
			ps.setString(4,"MASCULINO");
			ps.setNString(5, "3er semestre");
			ps.setInt(6, 1);
			
			int bandera = ps.executeUpdate();
			//Si ps.executeUpdate(); se ejecuta correctamente devuelve un valor entero de 1, si no devuelve 0
			
			//Condiciono ese valor para enviar un mensaje en consola
			if (bandera>0){
				System.out.println("Alumno registrado correctamente");
			}
			
		} catch (Exception e) {
			System.out.println("El registro no pudo insertarse");
			e.printStackTrace();
		}

	}

}
