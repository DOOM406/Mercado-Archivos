package com.juan.mercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Venta {

	private ArrayList<Producto> misProductos;
	// aca deberia armar el ticket, poniendo los productos en un .csv y un acumulador para el precio total

	public Venta(ArrayList<Producto> misProductos) {
		
		this.misProductos = misProductos;
	}
	
	public void cargarProductos(BufferedWriter archivo) {
		int b=1;
		for(Producto a : misProductos) {
			try {
				archivo.write(b+","+a.getNombre_producto()+","+a.getCantidad_producto()+","+a.getPrecio_producto());
				b++;
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public double calcularValor(BufferedReader archivo) {
		String linea;
		boolean primero = true; //saltamos encabezado
		double total=0;
		try {
			while((linea=archivo.readLine())!=null) {
				if(primero) {
					primero=false;
					continue;
				}
				
				//separar por coma
				String[] partes = linea.split(",");
				if(partes.length==4) {
					double valor=Double.parseDouble(partes[2].trim());
					total+=valor;
				}
				
				
			}
			return total;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0.0;
		
	}
	
	public void hacerTicktet(BufferedReader archivo) {
		
		String linea;
		boolean primera = true;
		
		try(BufferedWriter br  = new BufferedWriter(new FileWriter("ticket.csv"))){
			br.write("Id,Producto,Cantidad,$,Total");
			while((linea=archivo.readLine())!=null) {
				if(primera) {
					primera=false;
					continue;
				}
				br.write(linea);
			}
			double t = calcularValor(archivo);
			br.write(",,,,"+t);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
