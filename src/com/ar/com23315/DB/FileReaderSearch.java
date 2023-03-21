package com.ar.com23315.DB;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.reflect.TypeToken;
import com.ar.com23315.Models.ArticuloDTO;
import com.google.gson.Gson;

public class FileReaderSearch implements IConnection<ArrayList<ArticuloDTO>> {

	@Override
	public ArrayList<ArticuloDTO> execute() {
		
		System.out.println("Conectándose a FileReader");
		
		try {
			Reader reader = new FileReader("/com/ar/com23315/DB/pets.json");
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<ArticuloDTO>>(){}.getType();
			ArrayList<ArticuloDTO> list = gson.fromJson(reader, listType);
			
			return list;
		}
		catch(Exception ex) {
			System.out.println("Error al conectarse con FileReader. " + ex.getMessage());
		}
		return null;
	}
}
