package produccion;

import dao.PacienteDAO;
import dbImpl.PacienteDAODBImpl;
import ui.*;

//
public class Handler{

	BO miBO;
	MainFrame miFrame;
	PacienteDAO MiDao;
	
	 public Handler(){
		 
	 }
	 
	 //Aplicacion Principal
	 public void runapp() {
			//Crea BO y JFrame
						
			PacienteDAO miDao = new PacienteDAODBImpl();
			
			//crear Handler. Cargarle el BO y el Frame

			this.addBO(new BO(miDao));
			this.addMainFrame(new MainFrame());

			//Cargarle el handler al frame
			this.getMiFrame().addHandler(this);
			
			
			
		}
	//Declaro paneles

		
	public void crearPanel(String cliente, String panel){
		MainFrame frame = getMiFrame();
		frame.remove(frame.getContentPane());
		
		switch (panel) {
			case "Alta": frame.setContentPane(new AltaPanel(this.getMiBO()));break;
			case "Baja": frame.setContentPane(new BajaPanel(this.getMiBO()));break;
			case "Consulta": frame.setContentPane(new ConsultaPanel(this.getMiBO().getAllPacientes()));break;
			case "Modificacion": frame.setContentPane(new ModificacionPanel(this.getMiBO()));break;
		}
		
		frame.setTitle((panel + cliente));
		frame.revalidate();
		frame.repaint();
	}

	
	

	

	// metodos para agregar frame y bo
	public void addMainFrame(MainFrame miFrame) {
		System.out.println("Agregando Frame a Handler");
		this.miFrame = miFrame;
		
	}
	public void addBO(BO miBO) {
		System.out.println("Agregando BO a Handler");
		this.miBO = miBO;
	}
	
	private BO getMiBO() {
		return miBO;
	}

	private MainFrame getMiFrame() {
		return miFrame;
	}
	
	//para el final version 1
	// login
	// hace 1 entidad y tendria que haber generalizacion entre ambas
	
	
}


