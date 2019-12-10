package basics;
import javax.swing.JOptionPane;

import produccion.Handler;

public class Main{
	
	public static void main(String [] args) {
		
		try {
			new Handler().runapp();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo abrir la app.");
		}
	}
	

	
}
/**/