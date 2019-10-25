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

	

	public void crearPanelAlta(){
		miFrame.remove(miFrame.getContentPane());
		AltaPanel panelalta = new AltaPanel(this.getMiBO());
		miFrame.setContentPane(panelalta);
		miFrame.setTitle("Alta Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelBaja(){
		miFrame.remove(miFrame.getContentPane());
		BajaPanel panelbaja = new BajaPanel(this.getMiBO());
		miFrame.setContentPane(panelbaja);
		miFrame.setTitle("Baja Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelConsulta(){
		miFrame.remove(miFrame.getContentPane());
		ConsultaPanel panelconsulta = new ConsultaPanel(this.getMiBO().getAllPacientes());
		
		miFrame.setContentPane(panelconsulta);
		miFrame.setTitle("Consulta Pacientes");
		miFrame.revalidate();
		miFrame.repaint();
	}
	
	public void crearPanelModificacion(){
		miFrame.remove(miFrame.getContentPane());
		ModificacionPanel panelmodificacion = new ModificacionPanel(this.getMiBO());
		
		miFrame.setContentPane(panelmodificacion);
		miFrame.setTitle("Consulta Pacientes");
		miFrame.revalidate();
		miFrame.repaint();//ver de eliminar
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


