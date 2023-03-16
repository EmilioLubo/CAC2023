package com.ar.com23315.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ar.com23315.Models.ArticuloDTO;
import com.ar.com23315.Service.ISearch;
import com.microsoft.sqlserver.jdbc.SQLServerStatement;


public class MySqlSearch implements ISearch {

	private String connectionUrl = "jdbc:sqlserver://localhost:1434;instanceName=DESKTOP-FQOBUCCM;databaseName=PetsDB;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
	private Connection connection = null;
	private String query = "SELECT * FROM Pet";
	private ArticuloDTO[] art = new ArticuloDTO[3];

	
	public ArticuloDTO[] Search() {
		System.out.println("Buscando (MySql)...");
		
		try {
			connection = DriverManager.getConnection(connectionUrl);
			System.out.println("Conexión establecida" + connection.getCatalog());
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next()) {
				art[i] = new ArticuloDTO(rs.getInt("PetId"), rs.getString("PetName"), rs.getString("Breed"));
				i++;
			}
			return art;
		}
		catch (SQLException e) {
			System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
		}
		finally {
			if (connection != null) try { connection.close(); } catch(Exception e) {}
		}
		return art;
	}

}
