package ui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

import entidades.Medico;
import entidades.Paciente;
import entidades.Turno;
import produccion.Handler;

public class AsignarTurnosPanel extends AbstractPanel{
	//usar flowlayout--boxlayout

	List <Medico> listadomedicos;
	List <Paciente> listadopacientes;
	List <Date> listadodate;

	private String fecha;
	private JComboBox<PacienteItem> comboPaciente;
	private JComboBox<MedicoItem> comboMedico;
	private JComboBox<DateTimeItem> comboFecha;
	private Medico medico;
	private Paciente paciente;

	private JButton botonAgendar;
	private JButton botonEnviar;

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;


	public AsignarTurnosPanel(Handler handler) 
	{
		super(handler);
		listadomedicos=getHandler().obtenerTodosMedicos();
		listadopacientes=getHandler().obtenerPacientes();
		
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
				setMedico(medico);
				Turno buscaturno = new Turno(medico,fecha);

				getCajacombofecha().removeAllItems();
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

		//FECHAS
		this.add(new JLabel("Elegir fecha de turno: "));
		comboFecha.setPreferredSize(new Dimension(200,25));
		comboFecha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((DateTimeItem) getCajacombofecha().getSelectedItem() != null) {
					DateTimeItem fechaseleccionada= (DateTimeItem) getCajacombofecha().getSelectedItem();
					Date fechalocal = fechaseleccionada.getDate();
					setFecha(fechalocal);
				}
			}
		});
		this.add(comboFecha);
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
				setPaciente(paciente);
			}
		});
		this.add(comboPaciente);
		comboPaciente.setSelectedIndex(0);								//primero de la lista
		comboPaciente.setMaximumSize(comboPaciente.getPreferredSize());

		
		botonAgendar= new JButton("Agendar");
		botonAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) { 
				String fechaHora =getFecha();
				String reservado = "1";
				Medico medico = getMedico();
				Paciente paciente =getPaciente();
				Turno turno = new Turno(fechaHora, reservado, medico, paciente);
				getHandler().reservarTurnolibre(turno);
			}
		});
		this.add(botonAgendar);
		this.add(agregarSalirButton());
		

	}


	//botones
	public JButton getButtonEnviar(){
		return botonEnviar;
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


	private String getFecha() {
		return fecha;
	}

	public void setFecha(Date fechaseleccionada)  {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		String turnohora = df.format(fechaseleccionada);
		this.fecha = turnohora;
	}


	private Medico getMedico() {
		return medico;
	}

	private void setMedico(Medico medico) {
		this.medico = medico;
	}

	private Paciente getPaciente() {
		return paciente;
	}

	private void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	@Override
	public void buttonDeleteAction(String matricula) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void buttonCreateAction(String documento, String nombre, String apellido, String email) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void buttonCreateAction(String documento, String consultorio, String nombre, String apellido,
			String especialidad) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public JTable getCustomJTable() {
		// TODO Auto-generated method stub
		return null;
	}
}



