package com.ar.com23315.Models;

import com.ar.com23315.Service.ISearch;

public class Buscador {
	
	private String input;
	private ArticuloDTO[] listado;
	private int cantidad;
	
	private ISearch searchService;
	
	public Buscador(ISearch search) {
		this.searchService = search;
	}
	
	public void buscar() {
		
		this.SetListado(this.searchService.Search());
		
		SetCantidad(GetListado().length);
	}
	
	public void SetSearchService(ISearch searchService) {
		this.searchService = searchService;
	}
	
	public void SetInput(String i) {
		if(i == null) {
			this.input = "";
		}
		this.input = i;
	}
	
	public ArticuloDTO[] GetListado() {
		if(this.listado == null) {
			this.SetListado(new ArticuloDTO[0]);
		}
		return this.listado;
	}
	
	public void SetListado(ArticuloDTO[] art) {
		this.listado = art;
	}
	
	public int GetCantidad() {
		return this.cantidad;
	}
	
	private void SetCantidad(int n) {
		this.cantidad = n;
	}
	
	
}
