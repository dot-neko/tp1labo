package produccion;

import javax.swing.JOptionPane;

import dao.ConsultorioDAO;
import dbImpl.ConsultorioDAODBImpl;
import excepciones.BusinessException;
import ui.*;

//
public class Handler{

	BO miBO;
	MainFrame miFrame;
	ConsultorioDAO MiDao;
	
	 public Handler(){
		 
	 }
	 
	 //Aplicacion Principal
	 public void runapp() {
			//Crea BO y JFrame
						
			ConsultorioDAO miDao = new ConsultorioDAODBImpl();
			
			//crear Handler. Cargarle el BO y el Frame

			this.setBO(new BO(miDao));
			this.setMainFrame(new MainFrame());

			//Cargarle el handler al frame
			this.setMainFrame().setHandler(this);
			
			
			
		}
	//Declaro paneles

	

	public void crearPanelAltaPaciente(){
		miFrame.remove(miFrame.getContentPane());//TODO: VER COMO BORRAR PANEL Y NO PISAR EL ACTUAL
		AltaPanelPaciente panelalta = new AltaPanelPaciente();
		panelalta.setHandler(this);
		miFrame.setContentPane(panelalta);
		miFrame.setTitle("Alta Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelBajaPaciente(){
		miFrame.remove(miFrame.getContentPane());
		BajaPanelPaciente panelbaja = new BajaPanelPaciente(this);
		miFrame.setContentPane(panelbaja);
		miFrame.setTitle("Baja Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelConsultaPaciente(){
		miFrame.remove(miFrame.getContentPane());
		ConsultaPanelPaciente panelconsulta = new ConsultaPanelPaciente(this);
		
		miFrame.setContentPane(panelconsulta);
		miFrame.setTitle("Consulta Pacientes");
		miFrame.revalidate();
		miFrame.repaint();
	}
	
	public void crearPanelModificacionPaciente(){		
		ModificacionPanelPaciente panelmodificacion = new ModificacionPanelPaciente(this);
		
		miFrame.setContentPane(panelmodificacion);
		miFrame.setTitle("Modificacion Pacientes");
		miFrame.revalidate();
		miFrame.repaint();//ver de eliminar
	}

	/*
	public void crearPanelAltaMedico(){
		miFrame.remove(miFrame.getContentPane());
		AltaPanelPaciente panelalta = new AltaPanelMedico(this);
		miFrame.setContentPane(panelalta);
		miFrame.setTitle("Alta Medico");
		miFrame.repaint();
	}
	
	public void crearPanelBajaMedico(){
		miFrame.remove(miFrame.getContentPane());
		BajaPanelPaciente panelbaja = new BajaPanelMedico(this);
		miFrame.setContentPane(panelbaja);
		miFrame.setTitle("Baja Medico");
		miFrame.repaint();
	}
	
	public void crearPanelConsultaMedico(){
		miFrame.remove(miFrame.getContentPane());
		ConsultaPanelPaciente panelconsulta = new ConsultaPanelMedico(this);
		
		miFrame.setContentPane(panelconsulta);
		miFrame.setTitle("Consulta Medico");
		miFrame.revalidate();
		miFrame.repaint();
	}
	
	public void crearPanelModificacionMedico(){
		miFrame.remove(miFrame.getContentPane());
		ModificacionPanelPaciente panelmodificacion = new ModificacionPanelMedico(this);
		
		miFrame.setContentPane(panelmodificacion);
		miFrame.setTitle("Consulta Medico");
		miFrame.revalidate();
		miFrame.repaint();//ver de eliminar
	}
*/
	

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
	public void HandleBusinessException(BusinessException e) {
		JOptionPane.showMessageDialog(null, e.getMsj(), e.getTitle(), 1);
	}
	

	
	//
	public void IngresoPacienteOk() {
		JOptionPane.showMessageDialog(null, "Se ingreso Paciente correctamente.");
	}
	
	//para el final version 1
	// login
	// hace 1 entidad y tendria que haber generalizacion entre ambas
	
	
}

