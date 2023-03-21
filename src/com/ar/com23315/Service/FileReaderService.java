package com.ar.com23315.Service;

import java.util.ArrayList;

import com.ar.com23315.DB.FileReaderSearch;
import com.ar.com23315.DB.IConnection;
import com.ar.com23315.Models.ArticuloDTO;

public class FileReaderService implements IService {
	
	IConnection<ArrayList<ArticuloDTO>> connection;

	public FileReaderService() {
		connection = new FileReaderSearch();
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
