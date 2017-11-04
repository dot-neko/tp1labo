package basics;
import produccion.Handler;

public class Main{
	
	public static void main(String [] args) {
		
		try {
			Handler handler = new Handler();
			handler.crearPanelAlta();//llamo a mainpanel
		} catch (Exception e) {
			// TODO Devolver respuesta a usuario
			e.printStackTrace();
		}
	}
}
/**/