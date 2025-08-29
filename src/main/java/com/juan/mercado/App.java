package com.juan.mercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	public static Producto armarProducto(Scanner sc) {
		String nombre="";
		double precio=0;
		int cantidad=0;

		do {
			System.out.println("------Lista de productos------");
			System.out.println("1 - Limpiador de pisos - $450");
			System.out.println("2 - Secador - $300");
			System.out.println("3 - Tabla - $100");
			System.out.println("4 - Toalla - $200");
			System.out.println("5 - Lavandina $400");
			System.out.print(": ");
			int op = sc.nextInt();
			if(op<1 || op>5) {
				System.out.println("Opcion no valida, intente nuevamente");
			}else {
				System.out.print("Ingrese la cantidad: ");
				try {
					cantidad=sc.nextInt();
					switch (op) {
					case 1:
						precio=cantidad*450;
						nombre="Limpiador de pisos";
						break;
					case 2:
						precio=cantidad*300;
						nombre="Secador";
						break;
					case 3:
						precio=cantidad*100;
						nombre="Tabla";
						break;
					case 4:
						precio=cantidad*200;
						nombre="Toalla";
						break;
					case 5:
						precio=cantidad*400;
						nombre="Lavandina";
						break;
					}
					return new Producto(nombre, cantidad, precio);
				}catch (InputMismatchException e) {
					System.out.println("Error - Letras no validas");
					sc.nextLine();
				}
			}
		} while (nombre.isBlank() || precio<=0 || cantidad<=0);
		return null;
	}
	
	
	public static void main(String[] args) {

		//inicializar variables:
		Scanner sc = new Scanner(System.in);
		Venta miLista = new Venta(new ArrayList<Producto>());
		Cliente yo = new Cliente("Juan ", miLista);
		double t=0;
		while(true) {
			System.out.println("Quiere agregar un producto? s/n");
			String r = sc.next();
			if(r.equals("s")) {
				Producto tmp = armarProducto(sc);
				yo.getMi_ticket().getMisProductos().add(tmp);
			}else if(r.equals("n")) {
				//armamos csv
				try (BufferedWriter archivo1 = new BufferedWriter(new FileWriter("archivo1.csv"));){
					yo.getMi_ticket().cargarProductos(archivo1);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try (BufferedReader archivo_n = new BufferedReader(new FileReader("archivo1.csv"));){
					t=yo.getMi_ticket().calcularValor(archivo_n);
					yo.getMi_ticket().hacerTicktet(archivo_n,t);
				}catch(IOException e) {
					e.printStackTrace();
				}
				try (BufferedReader archivo_n = new BufferedReader(new FileReader("archivo1.csv"));){
					yo.getMi_ticket().hacerTicktet(archivo_n,t);
				}catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println("Datos cargados..");
				break;
			}
			
		}
		
	}
		// el codigo esta pensado para que puede almacenar varios clientes en una base de datos
		// donde desde ahi se pueda acceder a su lista de productos y eso
		// cosa que aun no sé xd 29/08/2025 1:36am
}
