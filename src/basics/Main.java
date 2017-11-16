package basics;
import produccion.Handler;

public class Main{
	
	public static void main(String [] args) {
		
		try {
			new Handler().runapp();
		} catch (Exception e) {
			// TODO Devolver respuesta a usuario
			e.printStackTrace();
		}
	}
	

	
}
/**/