package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Vendedores implements Serializable{
	private int codigo;
	private String nombre;
	private String categoria;
	
	ArrayList<Vehiculo> cochesVendidos= new ArrayList<Vehiculo>();
	
	public Vendedores(int codigo, String nombre, String categoria) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.categoria=categoria;
		
	}
	public Vendedores() {
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public ArrayList<Vehiculo> getCochesVendidos() {
		return cochesVendidos;
	}
	public void setCochesVendidos(ArrayList<Vehiculo> cochesVendidos) {
		this.cochesVendidos = cochesVendidos;
	}
	@Override
	public String toString() {
		return "Vendedores [codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + ", cochesVendidos="
				+ cochesVendidos + "]";
	}
	
	
	
	
}
