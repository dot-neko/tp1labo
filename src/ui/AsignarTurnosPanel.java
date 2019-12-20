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

import entidades.Medico;
import entidades.Paciente;
import entidades.Turno;
import produccion.Handler;

public class AsignarTurnosPanel extends JPanel{
	//usar flowlayout--boxlayout

	List <Medico> listadomedicos;
	List <Paciente> listadopacientes;
	List <Date> listadodate;
	private String documentomedico;
	private String documentopaciente;
	private String consultorio;
	private String fecha;
	private String reservado="1";
	private JComboBox<PacienteItem> comboPaciente;
	private JComboBox<MedicoItem> comboMedico;
	private JComboBox<DateTimeItem> comboFecha;

	private JButton botonAgendar;
	private JButton botonEnviar;
	private Handler handler;

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;


	public AsignarTurnosPanel(Handler handler) 
	{
		this.handler=handler;
		listadomedicos=getHandler().obtenerTodosMedicos();
		listadopacientes=getHandler().obtenerPacientes();
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		comboFecha = new JComboBox<DateTimeItem>();
		comboMedico= new JComboBox<MedicoItem>();//Instanciando ComboBox
		comboPaciente= new JComboBox<PacienteItem>();//Instanciando ComboBox

		//MEDICOS
		this.add(new JLabel("Buscar Medico : "));
		
		comboMedico.setPreferredSize(new Dimension(200,25));
		for (Medico medico : listadomedicos) {
			comboMedico.addItem(new MedicoItem(medico));
		}
		comboMedico.addActionListener(new ActionListener(	) {
			@Override
			public void actionPerformed(ActionEvent e) {
				MedicoItem medicoseleccion= (MedicoItem) getComboMedicos().getSelectedItem();
				Medico medico = (Medico) medicoseleccion.getMedico();
				String documento = medico.getDocumento();
				setDocumentoMedico(documento);
				getCajacombofecha().removeAllItems();
				Turno buscaturno = new Turno(documentomedico,fecha);
				listadodate=getHandler().buscarTurnosLibres(buscaturno);
				//Rellena Combobox Fechas
				for (Date date : listadodate) {
					getCajacombofecha().addItem(new DateTimeItem(date));
				}
			}
		});
		this.add(comboMedico);
		comboMedico.setSelectedIndex(0);
		comboMedico.setMaximumSize(comboMedico.getPreferredSize());
/*
		botonEnviar= new JButton("Buscar");
		botonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) { 
				

			}
		});
		this.add(botonEnviar);
*/
		//FECHAS
		this.add(new JLabel("Elegir fecha de turno: "));
		
		comboFecha.setPreferredSize(new Dimension(200,25));
		comboFecha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (getCajacombofecha().getItemCount()>0) {
					DateTimeItem fechaseleccionada= (DateTimeItem) getCajacombofecha().getSelectedItem();
					Date fechalocal = fechaseleccionada.getDate();
					setFecha(fechalocal);
				}
			}
		});
		this.add(comboFecha);
		/*comboFecha.setSelectedIndex(0);*/
		comboFecha.setMaximumSize(comboFecha.getPreferredSize() );


		//PACIENTES
		this.add(new JLabel("Buscar Paciente : "));

		
		comboPaciente.setPreferredSize(new Dimension(200,25));

		for (Paciente paciente : listadopacientes) {
			comboPaciente.addItem(new PacienteItem(paciente));
		}
		comboPaciente.addActionListener(new ActionListener(	) {

			@Override
			public void actionPerformed(ActionEvent e) {
				PacienteItem pacienteseleccion= (PacienteItem) getComboPaciente().getSelectedItem();
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
				Turno turno = new Turno(getDocumentoMedico(), getDocumentoPaciente(), getFecha(), getConsultorio(), getReservado());
				getHandler().reservarTurnolibre(turno);
				//Rellena Combobox Fechas


			}
		});
		this.add(botonAgendar);

		//Configuracion de panel
		this.setSize(300,  200);
		this.setLocation(0,20);
		this.setVisible(true);
	}






//botones
public JButton getButtonEnviar(){
	return botonEnviar;
}

public Handler getHandler() {
	return handler;
}

protected JComboBox<MedicoItem> getComboMedicos() {
	return comboMedico;
}

protected JComboBox<PacienteItem> getComboPaciente() {
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



