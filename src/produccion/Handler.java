package produccion;

import java.util.List;

import javax.swing.JOptionPane;

import dao.ConsultorioDAO;
import dbImpl.ConsultorioDAODBImpl;
import entidades.Medico;
import entidades.Paciente;
import excepciones.BusinessException;
import ui.*;

//
public class Handler{

	BO miBO;
	MainFrame miFrame;
	
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
		BajaPanelPaciente panelbaja = new BajaPanelPaciente();
		panelbaja.setHandler(this);
		miFrame.setContentPane(panelbaja);
		miFrame.setTitle("Baja Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelConsultaPaciente(){
		miFrame.remove(miFrame.getContentPane());
		ConsultaPanelPaciente panelconsulta = new ConsultaPanelPaciente();
		panelconsulta.setHandler(this);
		panelconsulta.InicializarPanel();
		miFrame.setContentPane(panelconsulta);
		miFrame.setTitle("Consulta Pacientes");
		miFrame.revalidate();
		miFrame.repaint();
	}
	
	public void crearPanelModificacionPaciente(){		
		ModificacionPanelPaciente panelmodificacion = new ModificacionPanelPaciente();
		panelmodificacion.setHandler(this);
		miFrame.setContentPane(panelmodificacion);
		miFrame.setTitle("Modificacion Pacientes");
		miFrame.revalidate();
		miFrame.repaint();//ver de eliminar
	}

	
	public void crearPanelAltaMedico(){
		miFrame.remove(miFrame.getContentPane());
		AltaPanelMedico panelaltamedico = new AltaPanelMedico();
		panelaltamedico.setHandler(this);
		miFrame.setContentPane(panelaltamedico);
		miFrame.setTitle("Alta Medico");
		miFrame.repaint();
	}
	
	public void crearPanelBajaMedico(){
		miFrame.remove(miFrame.getContentPane());
		BajaPanelMedico panelbajamedico = new BajaPanelMedico();
		panelbajamedico.setHandler(this);
		miFrame.setContentPane(panelbajamedico);
		miFrame.setTitle("Baja Medico");
		miFrame.repaint();
	}
	
	public void crearPanelConsultaMedico(){
		miFrame.remove(miFrame.getContentPane());
		ConsultaPanelMedico panelconsultamedico = new ConsultaPanelMedico();
		panelconsultamedico.setHandler(this);//TODO Ver si se puede hacer todo desde aca y mandar al panel el resultado solamente sin tener que pasarle el handler, ya que no hay interacciones
		panelconsultamedico.InicializarPanel();
		miFrame.setContentPane(panelconsultamedico);
		miFrame.setTitle("Consulta Medico");
		miFrame.revalidate();
		miFrame.repaint();
	}
	
	public void crearPanelModificacionMedico(){
		miFrame.remove(miFrame.getContentPane());
		ModificacionPanelMedico panelmodificacionmedico = new ModificacionPanelMedico();
		panelmodificacionmedico.setHandler(this);
		miFrame.setContentPane(panelmodificacionmedico);
		miFrame.setTitle("Modificacion Medico");
		miFrame.revalidate();
		miFrame.repaint();//ver de eliminar
	}

	public void IngresarPacienteCompleto(Paciente p) {
		try {
			getBO().ValidarPacienteNuevo(p);
			IngresoOk(p);
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
	}
	
	public void borrarPacienteByDocumento(Paciente p) {
		try {
			getBO().validarPacientebyDocumento(p);//TODO Ver de si no encuentra no diga que borró.
			BorradoOk(p);
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
	}
	
	public List<Paciente> ObtenerTodosPacientes() {
		List<Paciente> listapacientes = null;
		try {
			listapacientes=getBO().getAllPacientes();
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
		return listapacientes;
	}
	
	public Paciente BuscarPaciente(Paciente p) {
		try {
			p=getBO().validarPacienteporBusqueda(p);
			if (p.getNombre()==null) {
				ActualizadoError();
			}
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
		return p;
	}
	
	public void ActualizarPaciente(Paciente p) {
		try {
			getBO().updatePaciente(p);
			ActualizadoOk(p);
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
	}


	public void IngresarMedicoCompleto(Medico m) {
		try {
			getBO().ValidarMedicoNuevo(m);// estos dos metodos al handler y que no corran desde el bo, sino del handler como ingresook
			IngresoOk(m);
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
	}
	
	public void borrarMedicoByDocumento(Medico m) {
		try {
			getBO().validarMedicobyDocumento(m);
			BorradoOk(m);
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
	}
	
	public List<Medico> ObtenerTodosMedicos() {
		List<Medico> listamedicos = null;
		try {
			listamedicos=getBO().getAllMedicos();
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
		return listamedicos;
	}
	
	public Medico BuscarMedico(Medico m) {
		try {
			m=getBO().validarMedicoporBusqueda(m);
			if (m.getNombre()==null) {
				ActualizadoError();
			}
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
		return m;
	}
	
	public void ActualizarMedico(Medico m) {
		try {
			getBO().updateMedico(m);
			ActualizadoOk(m);
		} catch (BusinessException e) {
			HandleBusinessException(e);
		}
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
	public void HandleBusinessException(BusinessException e) {
		JOptionPane.showMessageDialog(null, e.getMsj(), e.getTitle(), 1);
	}
	

	
	// Jpane informacion
	protected void IngresoOk(Paciente p) {
		JOptionPane.showMessageDialog(null, "Se ingreso Paciente correctamente.");
	}
	protected void IngresoOk(Medico m) {
		JOptionPane.showMessageDialog(null, "Se ingreso Medico correctamente.");
	}
	protected void BorradoOk(Paciente p) {
		JOptionPane.showMessageDialog(null, "Se borro Paciente con documento = " + p.getDocumento());
	}
	protected void BorradoOk(Medico m) {
		JOptionPane.showMessageDialog(null, "Se borro Medico con documento = " + m.getDocumento());
	}
	protected void ActualizadoOk(Paciente p) {
		JOptionPane.showMessageDialog(null, "Se actualizo Paciente " + p.getDocumento() + " correctamente.");
	}
	protected void ActualizadoOk(Medico m) {
		JOptionPane.showMessageDialog(null, "Se actualizo Medico " + m.getDocumento() + " correctamente.");
	}
	protected void ActualizadoError() {
		JOptionPane.showMessageDialog(null, "No se encontro nada con el documento ingresado");
	}

	public void crearPanelAsignarTurnoNuevo() {
		// TODO Auto-generated method stub
		
	}

	public void crearPanelCreaTurnoMedico() {
		// TODO Auto-generated method stub
		
	}
	
	//para el final version 1
	// login
	// hace 1 entidad y tendria que haber generalizacion entre ambas
	
	
}

