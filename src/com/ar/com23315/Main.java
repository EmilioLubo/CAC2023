package com.ar.com23315;

import com.ar.com23315.Models.Buscador;
import com.ar.com23315.Service.ISearch;
import com.ar.com23315.Service.SearchFactory;

public class Main {
	public static void main(String[] args) {
		var env = "MYSQL";
		
		ISearch searchService = SearchFactory.GetSearch(env);
		
		String clave = "super";
		
		var buscador = new Buscador(searchService);
		
		buscador.SetInput(clave);
		
		buscador.buscar();
		
		System.out.println("Se encontraron los siguientes resultados : \n" + buscador.GetCantidad() + " resultados. \n");
		var lista  = buscador.GetListado();
		for(var el : lista) {
			System.out.println(el);			
		}
	}
}
