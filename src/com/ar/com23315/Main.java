package com.ar.com23315;

import java.util.ArrayList;

import com.ar.com23315.Models.ArticuloDTO;
import com.ar.com23315.Service.IService;
import com.ar.com23315.Service.ServiceFactory;

public class Main {
	public static void main(String[] args) throws Exception {
		var env = "READER";
		
		IService service = ServiceFactory.getService(env);
		
		ArrayList<ArticuloDTO> dto = service.invoke();
		
		if(dto != null) {
			for(var a : dto){
				System.out.println(a);
			}			
		}
		else {
			System.out.println("No se encontraron resultados");
		}
	}
}
