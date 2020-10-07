package vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import controlar.AppController;
import excepciones.CocheNoExiste;
import excepciones.VendedorNoExiste;
import modelo.Vehiculo;
import modelo.Vendedores;

public class AppMenuMain {

	public static void main(String[] args) throws VendedorNoExiste, CocheNoExiste, FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		int opcMenu=0;
		ArrayList<Vehiculo> vehiculos=new ArrayList<Vehiculo>();
		ArrayList<Vendedores> vendedores=new ArrayList<Vendedores>();
		Scanner entrada=new Scanner(System.in);
		AppController app=new AppController(vehiculos,vendedores);
		do {
			menu();
			try {
				opcMenu=Integer.parseInt(entrada.nextLine());	
			}catch(Exception e) {
				System.out.println("No es un numero");
			}
			switch(opcMenu) {
				case 0:
					System.out.println("Saliendo");
					break;
				case 1:
					app.importar();
					break;
				case 2:
					System.out.println("Vehiculo(0)|Vendedor(1)");
					int tipo=Integer.parseInt(entrada.nextLine());
					if(tipo==0) {
						System.out.println("Introduce la marca del vehiculo: ");
						String marca=entrada.nextLine();
						System.out.println("Modelo: ");
						String modelo=entrada.nextLine();
						System.out.println("Matricula: ");
						int matricula=Integer.parseInt(entrada.nextLine());
						System.out.println("Potencia: ");
						int potencia=Integer.parseInt(entrada.nextLine());
						System.out.println("Color: ");
						String color=entrada.nextLine();
						System.out.println("Precio");
						int precio=Integer.parseInt(entrada.nextLine());
						
						app.altaVehiculos(marca, modelo, matricula, potencia, color, precio);
					}if(tipo==1) {
						System.out.println("Codigo: ");
						int cod=Integer.parseInt(entrada.nextLine());
						System.out.println("Nombre: ");
						String nombre=entrada.nextLine();
						System.out.println("Categoria: ");
						String categoria=entrada.nextLine();
						app.altaVendedores(cod, nombre, categoria);
					}
					break;
				case 3:
					
					System.out.println("Introduce el codigo del vendedor para vender un coche: ");
					int cod=Integer.parseInt(entrada.nextLine());
					System.out.println("Introduce la matricula del coche a vender: ");
					int matricula=Integer.parseInt(entrada.nextLine());
					app.venderCoche(cod, matricula);
					break;
				case 4:
					app.exportar();
					break;
				case 5:
					app.crearCSV();
					break;
				case 6:
					app.mostrarArrayList();
					break;
			}
		}while(opcMenu!=0);
	}
	
	public static void menu() {
		System.out.println("1.Cargar datos.");
		System.out.println("2.Alta de vendedores y vehiculos.");
		System.out.println("3.Realizar venta");
		System.out.println("4.Guardar datos en ficheros");
		System.out.println("5.Crear csv");
		System.out.println("6.Array");
		System.out.println("0.Salir");
		System.out.println("Introduce una opcion: ");
		
	}

}
