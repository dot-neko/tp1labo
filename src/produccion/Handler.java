package produccion;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.PacienteDAO;
import dbImpl.PacienteDAODBImpl;
import excepciones.BusinessException;
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

			this.setBO(new BO(this,miDao));
			this.setMainFrame(new MainFrame());

			//Cargarle el handler al frame
			this.setMainFrame().setHandler(this);
			
			
			
		}
	//Declaro paneles

	

	public void crearPanelAlta(){
		miFrame.remove(miFrame.getContentPane());
		AltaPanel panelalta = new AltaPanel(this);
		miFrame.setContentPane(panelalta);
		miFrame.setTitle("Alta Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelBaja(){
		miFrame.remove(miFrame.getContentPane());
		BajaPanel panelbaja = new BajaPanel(this);
		miFrame.setContentPane(panelbaja);
		miFrame.setTitle("Baja Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelConsulta(){
		miFrame.remove(miFrame.getContentPane());
		ConsultaPanel panelconsulta = new ConsultaPanel(this);
		
		miFrame.setContentPane(panelconsulta);
		miFrame.setTitle("Consulta Pacientes");
		miFrame.revalidate();
		miFrame.repaint();
	}
	
	public void crearPanelModificacion(){
		miFrame.remove(miFrame.getContentPane());
		ModificacionPanel panelmodificacion = new ModificacionPanel(this);
		
		miFrame.setContentPane(panelmodificacion);
		miFrame.setTitle("Consulta Pacientes");
		miFrame.revalidate();
		miFrame.repaint();//ver de eliminar
	}

	
	

	

	// metodos para agregar frame y bo
	public void setMainFrame(MainFrame miFrame) {
		System.out.println("Agregando Frame a Handler");
		this.miFrame = miFrame;
		
	}
	public void setBO(BO miBO) {
		System.out.println("Agregando BO a Handler");
		this.miBO = miBO;
	}
	
	public BO getBO() {
		return miBO;
	}

	public MainFrame setMainFrame() {
		return miFrame;
	}
	
	// Business Exceptions
	//TODO: Agrupar excepciones en un solo metodo, asi las vistas no se tienen que enterar que tipo de excepcion mandar
	public void HandleBusinessException(BusinessException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), e.getErr(), 1);
		e.printStackTrace();
	}
	
	public void GeneralException(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), BusinessException.TITULO, 1);
		e.printStackTrace();
	}
	
	//
	public void IngresoPacienteOk() {
		JOptionPane.showMessageDialog(null, "Se ingreso Paciente correctamente.");// TIENEN QUE IR AL HANDLER
	}
	
	//para el final version 1
	// login
	// hace 1 entidad y tendria que haber generalizacion entre ambas
	
	
}

