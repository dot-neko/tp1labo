package produccion;


import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.ConsultorioDAO;
import dbImpl.ConsultorioDAODBImpl;
import entidades.Medico;
import entidades.Paciente;
import entidades.Turno;
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
	
	
	public void IngresarPacienteCompleto(Paciente p) {
		try {
			getBO().ValidarPacienteNuevo(p);
			ingresoOk(p);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public void borrarPacienteByDocumento(Paciente p) {
		try {
			getBO().validarPacientebyDocumento(p);//TODO Ver de si no encuentra no diga que borró.
			borradoOk(p);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public List<Paciente> ObtenerTodosPacientes() {
		List<Paciente> listapacientes = null;
		try {
			listapacientes=getBO().getAllPacientes();
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return listapacientes;
	}
	
	public Paciente buscarPaciente(Paciente p) {
		try {
			p=getBO().validarPacienteporBusqueda(p);
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
			getBO().updatePaciente(p);
			actualizadoOk(p);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}


	public void ingresarMedicoCompleto(Medico m) {
		try {
			getBO().ValidarMedicoNuevo(m);// estos dos metodos al handler y que no corran desde el bo, sino del handler como ingresook
			ingresoOk(m);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public void borrarMedicoByDocumento(Medico m) {
		try {
			getBO().validarMedicobyDocumento(m);
			borradoOk(m);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public List<Medico> obtenerTodosMedicos() {
		List<Medico> listamedicos = null;
		try {
			listamedicos=getBO().getAllMedicos();
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return listamedicos;
	}
	
	public Medico buscarMedico(Medico m) {
		try {
			m=getBO().validarMedicoporBusqueda(m);
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
			getBO().updateMedico(m);
			actualizadoOk(m);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
	}
	
	public void crearTurnos(Turno turno) {
		try {
			getBO().CrearTurnosMedico(turno);
			actualizadoOk(turno);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}		
	}
	
	public List <Date> buscarTurnosLibres(Turno buscaturno) {
		List<Date> turnoslibres = null;
		try {
			turnoslibres=getBO().BuscarTurnosLibres(buscaturno);
		} catch (BusinessException e) {
			handleBusinessException(e);
		}
		return turnoslibres;
	}
	
	
	public void reservarTurnolibre(Turno turno) {
		try {
			getBO().ReservaTurno(turno);
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
	public void setBO(BO miBO) {
		System.out.println("Agregando BO a Handler");
		this.miBO = miBO;
	}
	
	public BO getBO() {
		return miBO;
	}

	public MainFrame getMainFrame() {
		return miFrame;
	}
	
	// Business Exceptions
	public void handleBusinessException(BusinessException e) {
		JOptionPane.showMessageDialog(null, e.getMsj(), e.getTitle(), 1);
	}

	

	
	// Jpane informacion
	protected void ingresoOk(Paciente p) {
		JOptionPane.showMessageDialog(null, "Se ingreso Paciente correctamente.");
	}
	protected void ingresoOk(Medico m) {
		JOptionPane.showMessageDialog(null, "Se ingreso Medico correctamente.");
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
		JOptionPane.showMessageDialog(null, "Se ingreso correctamente los turnos para el día " + t.getFecha_hora());
	}
	protected void turnoIngresadoOk(Turno t) {
		JOptionPane.showMessageDialog(null, "Se asignó correctamente el turno para el dia " + t.getFecha_hora() + ""
										+ "para el paciente "+ t.getdocumentoPaciente()+".");
	}
	protected void actualizadoError() {
		JOptionPane.showMessageDialog(null, "No se encontro nada con el documento ingresado");
	}

	

	

	
	

	

	
	
	//para el final version 1
	// login
	// hace 1 entidad y tendria que haber generalizacion entre ambas
	
	
}

