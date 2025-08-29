package com.juan.mercado;

public class Cliente {

	private String nombre;
	private Venta mi_ticket;	
	
	public Cliente(String nombre, Venta mi_ticket) {
		
		this.nombre = nombre;
		this.mi_ticket = mi_ticket;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarProducto(Producto producto) {
		mi_ticket.getMisProductos().add(producto);
		
	}

	public Venta getMi_ticket() {
		return mi_ticket;
	}

	public void setMi_ticket(Venta mi_ticket) {
		this.mi_ticket = mi_ticket;
	}
	
	
	
}
