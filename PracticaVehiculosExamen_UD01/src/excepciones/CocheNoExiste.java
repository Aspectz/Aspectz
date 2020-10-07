package excepciones;

public class CocheNoExiste extends Exception {
		int matricula;
		
		public CocheNoExiste(int matricula) {
			this.matricula=matricula;
		}

		@Override
		public String toString() {
			return "No existe ese coche";
		}
		
}
