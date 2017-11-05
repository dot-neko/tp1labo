package basics;
import produccion.BO;
import produccion.Handler;
import ui.MainFrame;

public class Main{
	
	public static void main(String [] args) {
		
		try {
			runapp();
		} catch (Exception e) {
			// TODO Devolver respuesta a usuario
			e.printStackTrace();
		}
	}
	private static void runapp() {
		//Crea BO y JFrame
				BO miBO 	= new BO();
				MainFrame miFrame 	= new MainFrame();

				//crear Handler. Cargarle el BO y el Frame
				Handler miHandler = new Handler();
				miHandler.addBO(miBO);
				miHandler.addMainFrame(miFrame);

				//Cargarle el handler al frame
				miFrame.addHandler(miHandler);

		
	}

	
}
/**/