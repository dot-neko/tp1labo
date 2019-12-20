package produccion;


import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import dao.MedicoDAO;
import dao.PacienteDAO;
import dao.TurnoDAO;
import dbImpl.MedicoDAODBImpl;
import dbImpl.PacienteDAODBImpl;
import dbImpl.TurnoDAODBImpl;
import entidades.Medico;
import entidades.Paciente;
import entidades.Turno;
import excepciones.BusinessException;
import ui.*;

//
public class Handler{

	private MedicoBO medicoBO;
	MainFrame miFrame;
	private TurnoBO turnoBO;
	private PacienteBO pacienteBO;
	
	 public Handler(){
		 
	 }
	 
	 //Aplicacion Principal
	 public void runapp() {
			//Crea BO y JFrame
						
			MedicoDAO medicoDao = new MedicoDAODBImpl();
			PacienteDAO pacienteDao = new PacienteDAODBImpl();
			TurnoDAO turnoDao = new TurnoDAODBImpl();
			
			//crear Handler. Cargarle el BO y el Frame

			this.setMedicoBO(new MedicoBO(medicoDao));
			this.setPacienteBO(new PacienteBO(pacienteDao));
			this.setTurnoBO(new TurnoBO(turnoDao));
			
			this.setMainFrame(new MainFrame());

			//Cargarle el handler al frame
			this.getMainFrame().setHandler(this);
			
		}
	//Declaro paneles

	
	 

	public void setCustomJPanel(JPanel panel, String title) {
		miFrame.remove(miFrame.getContentPane());
		miFrame.setContentPane(panel);
		miFrame.setTitle(title);
		miFrame.revalidate();
		miFrame.repaint();
	}
	
	public void setCustomJTable(ConsultaPanel panel, String title) {
		miFrame.remove(miFrame.getContentPane());
		miFrame.setContentPane(panel);
		miFrame.setTitle(title);
		miFrame.revalidate();
		miFrame.repaint();
	}

	public JTable getPacienteJTable () {
		List<Paciente> pacienteList  = this.obtenerPacientes();
		JTable jtable = new JTable(new PacienteTableModel(pacienteList));
		return jtable;
	}
	
	public void IngresarPacienteCompleto(Paciente p) {
		try {
			getPacienteBO().IngresarPacienteNuevo(p);
			ingresoOk("Se ingreso Paciente correctamente.");
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public void borrarPacienteByDocumento(Paciente p) {
		try {
			getPacienteBO().borrarPacientebyDocumento(p);//TODO Ver de si no encuentra no diga que borró.
			borradoOk(p);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public List<Paciente> obtenerPacientes() {
		List<Paciente> listapacientes = null;
		try {
			listapacientes=getPacienteBO().getAllPacientes();
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return listapacientes;
	}
	
	public Paciente buscarPaciente(Paciente p) {
		try {
			p=getPacienteBO().obtenerPacienteporBusqueda(p);
			if (p.getNombre()==null) {
				actualizadoError();
			}
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return p;
	}
	
	public void actualizarPaciente(Paciente p) {
		try {
			getPacienteBO().updatePaciente(p);
			actualizadoOk(p);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}


	public void ingresarMedicoCompleto(Medico m) {
		try {
			getMedicoBO().ingresarMedicoNuevo(m);// estos dos metodos al handler y que no corran desde el bo, sino del handler como ingresook
			ingresoOk("Se ingreso Medico correctamente.");
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public void borrarMedicoByDocumento(Medico m) {
		try {
			getMedicoBO().borrarMedicoporDocumento(m);
			borradoOk(m);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public List<Medico> obtenerTodosMedicos() {
		List<Medico> listamedicos = null;
		try {
			listamedicos=getMedicoBO().getAllMedicos();
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return listamedicos;
	}
	
	public Medico buscarMedico(Medico m) {
		try {
			m=getMedicoBO().obtenerMedicoporDocumento(m);
			if (m.getNombre()==null) {
				actualizadoError();
			}
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return m;
	}
	
	public void actualizarMedico(Medico m) {
		try {
			getMedicoBO().updateMedico(m);
			actualizadoOk(m);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public void crearTurnos(Turno turno) {
		try {
			getTrunoBO().crearTurnosNuevo(turno);
			actualizadoOk(turno);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}		
	}
	
	public List <Date> buscarTurnosLibres(Turno buscaturno) {
		List<Date> turnoslibres = null;
		try {
			turnoslibres=getTrunoBO().buscarTurnosLibres(buscaturno);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return turnoslibres;
	}
	
	
	public void reservarTurnolibre(Turno turno) {
		try {
			getTrunoBO().reservaTurno(turno);
			turnoIngresadoOk(turno);
		} catch (BusinessException e){
			handleBusinessException(e);
		}
		
	}
	
	// metodos para agregar frame y bo
	public void setMainFrame(MainFrame miFrame) {
		System.out.println("Agregando Frame a Handler");
		this.miFrame = miFrame;
		
	}
	public void setMedicoBO(MedicoBO medicoBO) {
		System.out.println("Agregando BO Medico a Handler");
		this.medicoBO = medicoBO;
	}
	
	public void setPacienteBO(PacienteBO pacienteBO) {
		System.out.println("Agregando BO Paciente a Handler");
		this.pacienteBO = pacienteBO;
	}
	
	public void setTurnoBO(TurnoBO turnoBO) {
		System.out.println("Agregando BO Turno a Handler");
		this.turnoBO = turnoBO;
	}
	
	public MedicoBO getMedicoBO() {
		return medicoBO;
	}
	
	public PacienteBO getPacienteBO() {
		return pacienteBO;
	}
	
	public TurnoBO getTrunoBO() {
		return turnoBO;
	}

	public MainFrame getMainFrame() {
		return miFrame;
	}
	
	// Business Exceptions
	public void handleBusinessException(BusinessException e) {
		JOptionPane.showMessageDialog(null, e.getMsj(), e.getTitle(), 1);
	}

	

	
	// Jpane informacion
	protected void ingresoOk(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
	protected void borradoOk(Paciente p) {
		JOptionPane.showMessageDialog(null, "Se borro Paciente con documento = " + p.getDocumento());
	}
	protected void borradoOk(Medico m) {
		JOptionPane.showMessageDialog(null, "Se borro Medico con documento = " + m.getDocumento());
	}
	protected void actualizadoOk(Paciente p) {
		JOptionPane.showMessageDialog(null, "Se actualizo Paciente " + p.getDocumento() + " correctamente.");
	}
	protected void actualizadoOk(Medico m) {
		JOptionPane.showMessageDialog(null, "Se actualizo Medico " + m.getDocumento() + " correctamente.");
	}
	protected void actualizadoOk(Turno t) {
		JOptionPane.showMessageDialog(null, "Se ingreso correctamente los turnos para el día " + t.getfechaHora());
	}
	protected void turnoIngresadoOk(Turno t) {
		JOptionPane.showMessageDialog(null, "Se asignó correctamente el turno para el dia " + t.getfechaHora() + ""
										+ "para el paciente "+ t.getdocumentoPaciente()+".");
	}
	protected void actualizadoError() {
		JOptionPane.showMessageDialog(null, "No se encontro nada con el documento ingresado");
	}

	
	

	

	
	

	

	
	
	//para el final version 1
	// login
	// hace 1 entidad y tendria que haber generalizacion entre ambas
	
	
}

