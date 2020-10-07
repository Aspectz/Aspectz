package modelo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Vehiculo implements Serializable, Externalizable{
	private String marca;
	private String modelo;
	private int potencia;
	private String color;
	private int matricula;
	private int precio;
	
	public Vehiculo(String marca, String modelo, int potencia,int matricula,String color, int precio) {
		this.marca=marca;
		this.modelo=modelo;
		this.potencia=potencia;
		this.color=color;
		this.matricula=matricula;
		this.precio=precio;
	}
	public Vehiculo() {
		
	}
	
	@Override 
	public void writeExternal(ObjectOutput out) throws IOException{
		out.writeObject(marca);
		out.writeObject(modelo);
		out.writeInt(potencia);
		out.writeObject(color);
		out.writeInt(matricula);
		out.writeInt(encriptar(this.precio));

	}
	@Override 
	public void readExternal(ObjectInput inp) throws ClassNotFoundException,IOException{
		marca=(String)inp.readObject();
		modelo=(String)inp.readObject();
		potencia=inp.readInt();
		color=(String)inp.readObject();
		matricula=inp.readInt();
		int preciodes=inp.readInt();
		precio=desencriptar(preciodes);
	}
	
	public int encriptar(int precio) {
		String p="1"+precio+"1";
		int p2=Integer.parseInt(p);
		return p2;
	}
	public int desencriptar(int precio) {
		String p=String.valueOf(precio);
		p=p.substring(1,p.length()-1);
		
		return Integer.parseInt(p);
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + ", color=" + color
				+ ", matricula=" + matricula + ", precio=" + precio + "]";
	}

	
}
