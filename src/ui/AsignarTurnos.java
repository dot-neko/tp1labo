package ui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidades.BuscaTurno;
import entidades.Medico;
import entidades.Paciente;
import entidades.Turnos;
import produccion.Handler;

public class AsignarTurnos extends JPanel{
//usar flowlayout--boxlayout

	List <Medico> listadomedicos;
	List <Paciente> listadopacientes;
	List <Date> listadodate;
	private String documentomedico;
	private String documentopaciente;
	private String consultorio;
	private String fecha;
	private String reservado="1";
	private JComboBox<ComboPaciente> comboPaciente;
	private JComboBox<ComboMedico> comboMedico;
	private JComboBox<DateTimeItem> comboFecha;
	
	private JButton botonAgendar;
	private JButton botonEnviar;
	private Handler handler;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public AsignarTurnos() {
		
	}
	
	public void InicializarPanel() {
		{
			listadomedicos=getHandler().ObtenerTodosMedicos();
			listadopacientes=getHandler().ObtenerTodosPacientes();
			this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
			
			
			
			
			//MEDICOS
			this.add(new JLabel("Buscar Medico : "));
			comboMedico= new JComboBox<ComboMedico>();//Instanciando ComboBox
			comboMedico.setPreferredSize(new Dimension(200,25));
			for (Medico medico : listadomedicos) {
				comboMedico.addItem(new ComboMedico(medico));
			}
			comboMedico.addActionListener(new ActionListener(	) {
				@Override
				public void actionPerformed(ActionEvent e) {
					ComboMedico medicoseleccion= (ComboMedico) getComboMedicos().getSelectedItem();
					Medico medico = (Medico) medicoseleccion.getMedico();
					String documento = medico.getDocumento();
					setDocumentoMedico(documento);
				}
			});
			this.add(comboMedico);
			comboMedico.setSelectedIndex(0);
			comboMedico.setMaximumSize(comboMedico.getPreferredSize());
			
			botonEnviar= new JButton("Buscar");
			botonEnviar.addActionListener(new ActionListener() {
	              public void actionPerformed(ActionEvent actionEvent) { 
	            	  BuscaTurno buscaturno = new BuscaTurno(documentomedico,fecha);
	            	  listadodate=getHandler().BuscarTurnosLibres(buscaturno);
	            	  //Rellena Combobox Fechas
	            	  for (Date date : listadodate) {
	            		  getCajacombofecha().addItem(new DateTimeItem(date));
	            		  }
	            	  
	              }
	        });
			this.add(botonEnviar);

			//FECHAS
			this.add(new JLabel("Elegir fecha de turno: "));
			comboFecha = new JComboBox<DateTimeItem>();
			comboFecha.setPreferredSize(new Dimension(200,25));
			comboFecha.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					DateTimeItem fechaseleccionada= (DateTimeItem) getCajacombofecha().getSelectedItem();
					Date fechalocal = fechaseleccionada.getDate();
					setFecha(fechalocal);
				}
			});
			this.add(comboFecha);
			/*comboFecha.setSelectedIndex(0);*/
			comboFecha.setMaximumSize(comboFecha.getPreferredSize() );
			
			
			//PACIENTES
			this.add(new JLabel("Buscar Paciente : "));
			
			comboPaciente= new JComboBox<ComboPaciente>();//Instanciando ComboBox
			comboPaciente.setPreferredSize(new Dimension(200,25));
			
			for (Paciente paciente : listadopacientes) {
				comboPaciente.addItem(new ComboPaciente(paciente));
			}
			comboPaciente.addActionListener(new ActionListener(	) {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ComboPaciente pacienteseleccion= (ComboPaciente) getComboPaciente().getSelectedItem();
					Paciente paciente = (Paciente) pacienteseleccion.getPaciente();
					String documento = paciente.getDocumento();
					setDocumentoPaciente(documento);
				}

			});
			this.add(comboPaciente);
			comboPaciente.setSelectedIndex(0);								//primero de la lista
			comboPaciente.setMaximumSize(comboPaciente.getPreferredSize());
			
			
			botonAgendar= new JButton("Agendar");
			botonAgendar.addActionListener(new ActionListener() {
	              public void actionPerformed(ActionEvent actionEvent) { 
	            	  Turnos turno = new Turnos(getDocumentoMedico(), getDocumentoPaciente(), getFecha(), getConsultorio(), getReservado());
	            	  getHandler().ReservarTurnolibre(turno);
	            	  //Rellena Combobox Fechas
	            	  
	            	  
	              }
	        });
			this.add(botonAgendar);
			
			//Configuracion de panel
			this.setSize(300,  200);
			this.setLocation(0,20);
			this.setVisible(true);
		}
		
	}
	

	

	//botones
	public JButton getButtonEnviar(){
		return botonEnviar;
	}

	public Handler getHandler() {
		return handler;
	}

	protected JComboBox<ComboMedico> getComboMedicos() {
		return comboMedico;
	}
	
	protected JComboBox<ComboPaciente> getComboPaciente() {
		return comboPaciente;
	}
	
	protected JComboBox<DateTimeItem> getCajacombofecha() {
		return comboFecha;
	}

	protected void setDocumentoMedico(String documento) {
		this.documentomedico = documento;
	}
	
	protected String getDocumentoMedico() {
		return documentomedico;
	}
	
	protected void setDocumentoPaciente(String documento) {
		this.documentopaciente = documento;
	}
	
	protected String getDocumentoPaciente() {
		return documentopaciente;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(Date fechaseleccionada) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		String turnohora = df.format(fechaseleccionada);
		this.fecha = turnohora;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public String getReservado() {
		return reservado;
	}
}
	
	

