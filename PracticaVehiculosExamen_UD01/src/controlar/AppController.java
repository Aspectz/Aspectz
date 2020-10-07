package controlar;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import excepciones.CocheNoExiste;
import excepciones.VendedorNoExiste;
import modelo.Vehiculo;
import modelo.Vendedores;

public class AppController {
	
	ArrayList<Vehiculo> vehiculos;
	ArrayList<Vendedores> vendedores;
	Scanner entrada=new Scanner(System.in);
	File fichVehiculos=new File("BaseDatos\\ficherovehiculo.obj");
	File fichVendedor=new File("BaseDatos\\ficherovendedor.obj");
	File vendedorCSV=new File("BaseDatos\\vendedorcsv.txt");
	public AppController() {
	}
	public AppController(ArrayList<Vehiculo> vehiculos,ArrayList<Vendedores> vendedores) {
		this.vehiculos=new ArrayList<Vehiculo>();
		this.vendedores=new ArrayList<Vendedores>();
	}
	
	public void altaVendedores(int codigo,String nombre,String categoria) {
		if(buscarVendedor(codigo)!=null) {
			System.out.println("Ya existe un vendedor con ese codigo!");
		}else {
			Vendedores vendedor=new Vendedores(codigo,nombre,categoria);
			vendedores.add(vendedor);
		}
	}
	public void altaVehiculos(String marca,String modelo,int matricula,int potencia,String color,int precio) {
		if(buscarVehiculo(matricula)!=null) {
			System.out.println("Ya existe un coche con esa matricula!");
		}else {
			Vehiculo vehiculo=new Vehiculo(marca,modelo,potencia,matricula,color,precio);
			vehiculos.add(vehiculo);
		}
	}
	
	public void venderCoche(int cod,int matricula) throws VendedorNoExiste, CocheNoExiste {
		
		if(buscarVendedor(cod)!=null) {
			if(buscarVehiculo(matricula)!=null) {
				Vendedores vend=buscarVendedor(cod);
				Vehiculo vehi=buscarVehiculo(matricula);
				vend.getCochesVendidos().add(vehi);
				System.out.println("Coche vendido correctamente");
			}else{
				throw new CocheNoExiste(matricula);
			}
		}else {
			throw new VendedorNoExiste(cod);
		}	
	}
	
	public void exportar() throws FileNotFoundException, IOException {
		ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(fichVehiculos));
		for(Vehiculo v : vehiculos) 
			v.writeExternal(obj);
		obj.close();
		obj=new ObjectOutputStream(new FileOutputStream(fichVendedor));
		for(Vendedores vend : vendedores)
			obj.writeObject(vend);
			
		obj.close();
	}
	
	public void importar() throws ClassNotFoundException, IOException {
		ObjectInputStream inp=new ObjectInputStream(new FileInputStream(fichVehiculos));
		boolean continuar=true;
		boolean cont=true;
		Vehiculo vehiculo=new Vehiculo();
		Vendedores vendedor;
		while(continuar) {
			try {
				vehiculo.readExternal(inp);
				vehiculos.add(vehiculo);
			}catch(IOException e) {
				System.out.print("");
				continuar=false;
			}
		}
		inp=new ObjectInputStream(new FileInputStream(fichVendedor));
		while(cont) {
			try {
				vendedor=(Vendedores)inp.readObject();
				vendedores.add(vendedor);
			}catch(IOException e) {
				System.out.print("");
				cont=false;
			}
		}
	}
			
	public Vendedores buscarVendedor(int codigo) {
		if(!vendedores.isEmpty()) {
			for(Vendedores v : vendedores) {
				if(v.getCodigo()==codigo) {
					return v;
				}
				
			}
		}

		return null;
	}
	public Vehiculo buscarVehiculo(int matricula) {
		if(!vehiculos.isEmpty()) {
			for(Vehiculo v : vehiculos) {
				if(v.getMatricula()==matricula) {
					return v;
				}
			}
		}
		return null;
		
	}
	public void crearCSV() throws IOException {
		PrintWriter pw=new PrintWriter(new FileWriter(vendedorCSV));
		for(Vehiculo v : vehiculos) {
			pw.println("Marca;Modelo;Matricula;potencia;color;precio");
			pw.println(v.getMarca()+";"+v.getModelo()+";"+v.getMatricula()+";"+v.getPotencia()+";"+v.getColor()+";"+v.getPrecio());
		}
		pw.close();
	}
	public void mostrarArrayList() {
		Iterator<Vehiculo> itVehiculo=vehiculos.iterator();
		Iterator<Vendedores> itVendedor=vendedores.iterator();
		System.out.println("\n-----------VEHICULOS-----------\n");
		while(itVehiculo.hasNext()) {
			System.out.println(itVehiculo.next());
		}
		System.out.println("\n-----------VENDEDORES----------\n");
		while(itVendedor.hasNext()) {
			System.out.println(itVendedor.next());
		}
		System.out.println();
	}
}
