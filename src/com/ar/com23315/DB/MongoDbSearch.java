package com.ar.com23315.DB;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.bson.Document;
import com.ar.com23315.Models.ArticuloDTO;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoDbSearch implements IConnection<ArrayList<ArticuloDTO>> {
	
	private MongoClient mc = null;
	
	public ArrayList<ArticuloDTO> execute() {
		
		System.out.println("Buscando (Mongo)...");
		Properties props = new Properties();
		
		try {
			
			InputStream input = new FileInputStream("config.properties");
			props.load(input);
			
			mc = MongoClients.create(props.getProperty("mongoConnection"));
			MongoDatabase database = mc.getDatabase("PetsDB");
			
			MongoCollection<Document> coleccion = database.getCollection("Pets");
		    List<Document> listaDocumentos = coleccion.find().into(new ArrayList<>());
		    
		    var list = new ArrayList<ArticuloDTO>();
		    
		    for (var d : listaDocumentos) {
		    	list.add(new ArticuloDTO(d.getInteger("PetId"), d.getString("PetName"),d.getString("Breed"))); 
		    }
		    
		    return list;
		}
		catch(Exception ex) {
			System.out.println("Error al conectarse a la base de datos. " + ex.getMessage() );
		}
		finally {
			if (mc != null) try { mc.close(); } catch(Exception e) {}
		}
		
		return null;		
	}
}
