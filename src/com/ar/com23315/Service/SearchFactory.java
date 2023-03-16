package com.ar.com23315.Service;

import com.ar.com23315.DB.MySqlSearch;

public class SearchFactory {
	
	public static ISearch GetSearch(String key) {
		
		ISearch searchService;
				
		switch(key) {
		case "API": searchService = new MySqlSearch();
					break;
		case "MYSQL": searchService = new MySqlSearch();
					break;
		case "MONGO": searchService = new MySqlSearch();
					break;
		default: throw new RuntimeException("No existe implementación para " + key + ".");
		}
		
		return searchService;
	}
}
