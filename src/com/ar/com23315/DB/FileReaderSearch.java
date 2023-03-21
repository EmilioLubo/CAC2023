package com.ar.com23315.DB;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.google.gson.reflect.TypeToken;
import com.ar.com23315.Models.ArticuloDTO;
import com.google.gson.Gson;

public class FileReaderSearch implements IConnection<ArrayList<ArticuloDTO>> {

	@Override
	public ArrayList<ArticuloDTO> execute() {
		
		System.out.println("Conectándose a FileReader");
		Properties props = new Properties();
		
		try {
			
			InputStream input = new FileInputStream("config.properties");
			props.load(input);
			
			Reader reader = new FileReader(props.getProperty("fileUrl"));
			Gson gson = new Gson();
			Type listType = new TypeToken<List<ArticuloDTO>>(){}.getType();
			ArrayList<ArticuloDTO> list = gson.fromJson(reader, listType);
			
			return list;
		}
		catch(Exception ex) {
			System.out.println("Error al conectarse con FileReader. " + ex.getMessage());
		}
		return null;
	}
}
