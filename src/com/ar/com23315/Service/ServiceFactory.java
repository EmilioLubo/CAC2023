package com.ar.com23315.Service;


public class ServiceFactory {
	
	public static IService getService(String key) {
				
		return switch(key) {
			case "MYSQL": {
				yield new MySqlService();
			}
			default: throw new RuntimeException("No existe implementación para " + key + ".");
		};
	}
}
