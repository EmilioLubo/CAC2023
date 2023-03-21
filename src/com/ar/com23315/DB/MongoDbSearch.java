package com.ar.com23315.DB;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.ar.com23315.Models.ArticuloDTO;
import com.ar.com23315.Service.IService;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


public class MongoDbSearch implements IConnection<ArrayList<ArticuloDTO>> {
	
	private String host = "mongodb+srv://emilubo:s3aWZbQ2528WEVQb@petdb.zrza9oh.mongodb.net/test";
	private MongoClient mc = null;
	
	public ArrayList<ArticuloDTO> execute() {
		
		System.out.println("Buscando (Mongo)...");
		
		try {
			
			mc = MongoClients.create(host);
			MongoDatabase database = mc.getDatabase("PetsDB");
			
			MongoCollection<Document> coleccion = database.getCollection("Pets");
		    List<Document> listaDocumentos = coleccion.find().into(new ArrayList<>());
		    
		    var list = new ArrayList<ArticuloDTO>();
		    
		    for (var d : listaDocumentos) {
		    	list.add(new ArticuloDTO(d.getInteger("PetId"), d.getString("PetName"),d.getString("Breed"))); 
		    }
		    
		    return list;
		}
		catch(MongoException ex) {
			System.out.println("Error al conectarse a la base de datos. " + ex.getMessage() );
		}
		finally {
			if (mc != null) try { mc.close(); } catch(Exception e) {}
		}
		
		return null;		
	}
}
