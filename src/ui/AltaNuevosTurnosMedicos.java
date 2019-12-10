package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidades.Medico;
import entidades.Turnos;
import produccion.Handler;

public class AltaNuevosTurnosMedicos extends JPanel{
//usar flowlayout--boxlayout

	List <Medico> listadomedicos;
	private String documentomedico;
	private String consultorio;
	private String fecha;
	private String reservado="0";
	private JComboBox<ComboMedico> comboMedicos;
	private JComboBox<DateItem> cajacombofecha;
	

	private JButton botonEnviar;
	private Handler handler;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public AltaNuevosTurnosMedicos() {
		
	}
	
	public void InicializarPanel() {
		{
			listadomedicos=getHandler().ObtenerTodosMedicos();
			this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
			
			
			this.add(new JLabel("Buscar Medico : "));
			comboMedicos= new JComboBox<ComboMedico>();//Instanciando ComboBox
			for (Medico medico : listadomedicos) {
				comboMedicos.addItem(new ComboMedico(medico));
			}
			comboMedicos.addActionListener(new ActionListener(	) {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ComboMedico medicoseleccion= (ComboMedico) getComboMedicos().getSelectedItem();
					Medico medico = (Medico) medicoseleccion.getMedico();
					String documento = medico.getDocumento();
					String consultorio = medico.getConsultorio();
					setDocumento(documento);
					setConsultorio(consultorio);
				}
			});
			this.add(comboMedicos);
			comboMedicos.setSelectedIndex(0);
			comboMedicos.setMaximumSize(comboMedicos.getPreferredSize());
			
			
			this.add(new JLabel("Elegir fecha a agregar : "));
			Calendar calendar = Calendar.getInstance();//Instancio calendario
			cajacombofecha = new JComboBox<DateItem>();
			for (int i = 0; i < 28; ++i) {
				cajacombofecha.addItem(new DateItem(calendar.getTime()));
			    calendar.add(Calendar.DATE, 1);			//Agrego 28 fechas a partir de hoy
			}
			cajacombofecha.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DateItem fechaseleccionada= (DateItem) getCajacombofecha().getSelectedItem();
					Date fechalocal = fechaseleccionada.getDate();
					setFecha(fechalocal);
				}
			});
			this.add(cajacombofecha);
			cajacombofecha.setSelectedIndex(0);
			cajacombofecha.setMaximumSize(cajacombofecha.getPreferredSize());
			
			botonEnviar= new JButton("Enviar");
			botonEnviar.addActionListener(new ActionListener() {
	              public void actionPerformed(ActionEvent actionEvent) { 

	        		
	            	  Turnos turno = new Turnos(documentomedico,fecha,consultorio,reservado);
	            	  getHandler().CrearTurnos(turno);
	              }
	        });
			this.add(botonEnviar);

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

	public JComboBox<ComboMedico> getComboMedicos() {
		return comboMedicos;
	}
	
	public JComboBox<DateItem> getCajacombofecha() {
		return cajacombofecha;
	}

	public void setDocumento(String documento) {
		this.documentomedico = documento;
	}
	
	public String getDocumentomedico() {
		return documentomedico;
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

}
	
	

