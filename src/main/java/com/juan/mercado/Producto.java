package com.juan.mercado;

public class Producto {

	private String nombre_producto;
	private int cantidad_producto;
	private float precio_producto;
	
	public Producto(String nombre_producto, int cantidad_producto, float precio_producto) {
		
		
		this.nombre_producto = nombre_producto;
		this.cantidad_producto = cantidad_producto;
		this.precio_producto = precio_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public float getPrecio_producto() {
		return precio_producto*cantidad_producto;
	}

	public void setPrecio_producto(float precio_producto) {
		this.precio_producto = precio_producto;
	}
	
	
	
}
