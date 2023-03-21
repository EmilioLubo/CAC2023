package com.ar.com23315.Service;

import java.util.ArrayList;

import com.ar.com23315.DB.IConnection;
import com.ar.com23315.DB.MongoDbSearch;
import com.ar.com23315.Models.ArticuloDTO;

public class MongoDbService implements IService {
	
	IConnection<ArrayList<ArticuloDTO>> connection;

	public MongoDbService() {
		connection = new MongoDbSearch();
	}
	
	@Override
	public ArrayList<ArticuloDTO> invoke() {
		
		ArrayList<ArticuloDTO> list = connection.execute();
		
		if(list.size() > 0) {
			return list;
		}
		return null;
	}

}
