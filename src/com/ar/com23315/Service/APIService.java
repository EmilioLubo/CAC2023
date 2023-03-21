package com.ar.com23315.Service;

import java.util.ArrayList;

import com.ar.com23315.DB.APISearch;
import com.ar.com23315.DB.IConnection;
import com.ar.com23315.Models.ArticuloDTO;

public class APIService implements IService {
	
	IConnection<ArrayList<ArticuloDTO>> connection;
	
	public APIService() {
		connection = new APISearch();
	}
	@Override
	public ArrayList<ArticuloDTO> invoke() {
		
		ArrayList<ArticuloDTO> list = connection.execute();
		
		if(list != null) {
			if(list.size() > 0) {
				return list;
			}			
		}
		
		return null;
	}
	
}
