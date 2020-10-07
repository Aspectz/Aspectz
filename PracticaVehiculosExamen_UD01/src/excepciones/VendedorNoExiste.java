package excepciones;

public class VendedorNoExiste extends Exception{
	int cod;
	public VendedorNoExiste(int cod) {
		this.cod=cod;
	}
	@Override
	public String toString() {
		return "No existe ese vendedor";
	}
	
	
	
}
