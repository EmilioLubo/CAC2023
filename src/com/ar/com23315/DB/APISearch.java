package com.ar.com23315.DB;

import com.ar.com23315.Models.ArticuloDTO;
import com.ar.com23315.Service.ISearch;

public class APISearch implements ISearch {

	public ArticuloDTO[] Search() {
		System.out.println("Buscando (API)...");
		
		return new ArticuloDTO[] {};
	}

}
