package com.ar.com23315.Service;

import java.util.ArrayList;
import com.ar.com23315.DB.IConnection;
import com.ar.com23315.DB.MySqlSearch;
import com.ar.com23315.Models.ArticuloDTO;

public class MySqlService implements IService {

	IConnection<ArrayList<ArticuloDTO>> connection;
	
	public MySqlService() {
		connection = new MySqlSearch();
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
