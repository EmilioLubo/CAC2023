package com.ar.com23315.DB;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ar.com23315.Models.ArticuloDTO;

public class MySqlSearch implements IConnection<ArrayList<ArticuloDTO>> {

	private Connection connection = null;
	private String query = "SELECT * FROM Pet";

	
	public ArrayList<ArticuloDTO> execute() {
		
		System.out.println("Buscando (MySql)...");
		Properties props = new Properties();
		
		try {
			
			InputStream input = new FileInputStream("config.properties");
			props.load(input);
			
			connection = DriverManager.getConnection(props.getProperty("sqlConnection"));
			System.out.println("Conexión establecida con " + connection.getCatalog());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			ArrayList<ArticuloDTO> list = new ArrayList<ArticuloDTO>();
			
			while(rs.next()) {
				list.add(new ArticuloDTO(rs.getInt("PetId"), rs.getString("PetName"), rs.getString("Breed")));
			}
			
			return list;
		}
		catch (Exception e) {
			System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
		}
		finally {
			if (connection != null) try { connection.close(); } catch(Exception e) {}
		}
		return null;
	}

}
