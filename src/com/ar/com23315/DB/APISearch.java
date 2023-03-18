package com.ar.com23315.DB;

import java.util.ArrayList;
import com.ar.com23315.Models.ArticuloDTO;
import com.ar.com23315.Service.IService;

public class APISearch implements IService {

	public ArrayList<ArticuloDTO> invoke() {
		System.out.println("Buscando (API)...");
		
		return new ArrayList<ArticuloDTO>();
	}

}
