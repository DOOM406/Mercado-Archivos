package com.juan.mercado;

public class Cliente {

	private String nombre;
	private Producto producto;
	private Venta mi_ticket;	
	
	public Cliente(String nombre, Producto producto) {
		
		this.nombre = nombre;
		this.producto = producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}
