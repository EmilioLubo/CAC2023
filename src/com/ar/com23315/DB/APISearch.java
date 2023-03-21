package com.ar.com23315.DB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import com.ar.com23315.Models.ArticuloDTO;
import com.ar.com23315.Models.Pet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class APISearch implements IConnection<ArrayList<ArticuloDTO>> {
	
	private String url = "https://localhost:44353/api/Pet/";

	public ArrayList<ArticuloDTO> execute() {
		System.out.println("Buscando (API)...");
		
		try {
			SSLContext ssl = SSLContext.getInstance("TLS");
			ssl.init(null, new TrustManager[]{ new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] x509Certificate, String s) throws CertificateException{
				}
				public void checkServerTrusted(X509Certificate[] x509Certificate, String s) throws CertificateException{
				}
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}
			}}, new SecureRandom());
			URL uri = new URL(this.url);
			HttpsURLConnection con = (HttpsURLConnection) uri.openConnection();
			con.setSSLSocketFactory(ssl.getSocketFactory());
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "*/*");
			con.connect();
			int responseCode = con.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
			    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			    String inputLine;
			    StringBuffer response = new StringBuffer();

			    while ((inputLine = in.readLine()) != null) {
			        response.append(inputLine);
			    }
			    in.close();
			    ObjectMapper om = new ObjectMapper();
			
			    ArrayList<ArticuloDTO> list = new ArrayList<ArticuloDTO>();
			
			    List<Pet> result = om.readValue(response.toString(), new TypeReference<List<Pet>>() {});
			
			    for (Pet p : result) {
			    	ArticuloDTO dto = new ArticuloDTO(p.getPetId(), p.getPetName(), p.getBreed());
			    	list.add(dto);
			    }
			
			    return list;
			}
			else {
				    System.out.println("La solicitud falló. Código de respuesta: " + responseCode);
			}
			con.disconnect();
		}
		catch (Exception e) {
			System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
		}
		return null;
	}

}
