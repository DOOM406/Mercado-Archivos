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
	
	public void cargarProductos(BufferedWriter archivo) throws IOException {
		int b=1;
		archivo.write("Id,Producto,Cantidad,Precio\n");
		for(Producto a : misProductos) {
			archivo.write(b+","+a.getNombre_producto()+","+a.getCantidad_producto()+","+a.getPrecio_producto());
			archivo.newLine();
			b++;

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
					double valor=Double.parseDouble(partes[3].trim());
					total+=valor;
				}
				
			}
			return total;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return 0.0;
		
	}
	
	public void hacerTicktet(BufferedReader archivo,double t) {
		
		String linea;
		boolean primera = true;
		
		try(BufferedWriter br  = new BufferedWriter(new FileWriter("ticket.csv"))){
			br.write("Id,Producto,Cantidad,$,Total\n");
			System.out.println("b");
			while((linea=archivo.readLine())!=null) {
				System.out.println("c");
				if(primera) {
					primera=false;
					continue;
				}
				System.out.println("a");
				br.write(linea+"\n");
			}
			br.write(",,,,"+t);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}

	public void mostarLista(BufferedReader archivo) {
		String linea;
		boolean encabezado=true;
		
		try {
			while((linea=archivo.readLine())!=null) {
				if(encabezado) {
					encabezado=false;
					continue;
				}
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
