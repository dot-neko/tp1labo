package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Medico;
import produccion.Handler;

public class AltaPanelMedico extends JPanel{
//usar flowlayout--boxlayout
	private JTextField txtDocumento;
	private JTextField txtConsultorio;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEspecialidad;
	private JButton botonEnviar;
	private Handler handler;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public AltaPanelMedico(){
		{
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			
			this.add(new JLabel("Documento : "));
			this.add(txtDocumento=new JTextField(15));
			txtDocumento.setMaximumSize(txtDocumento.getPreferredSize());
			
			this.add(new JLabel("Consultorio : "));
			this.add(txtConsultorio=new JTextField(15));
			txtConsultorio.setMaximumSize(txtConsultorio.getPreferredSize());
			
			this.add(new JLabel("Nombre : "));
			this.add(txtNombre=new JTextField(20));
			txtNombre.setMaximumSize(txtNombre.getPreferredSize());
			
			this.add(new JLabel("Apellido : "));
			this.add(txtApellido=new JTextField(20));
			txtApellido.setMaximumSize(txtApellido.getPreferredSize());
			
			this.add(new JLabel("Especialidad : "));
			this.add(txtEspecialidad=new JTextField(30));
			txtEspecialidad.setMaximumSize(txtEspecialidad.getPreferredSize());
			
			botonEnviar= new JButton("Enviar");
			botonEnviar.addActionListener(new ActionListener() {
	              public void actionPerformed(ActionEvent actionEvent) { 
	            	  String documento= getTxtDocumento().getText();
	            	  String consultorio= getTxtConsultorio().getText();
            		  String nombre= getTxtNombre().getText();
            		  String apellido= getTxtApellido().getText();
	            	  String especialidad = getTxtEspecialidad().getText();
	            	  Medico m= new Medico(documento, consultorio, nombre, apellido, especialidad);
	        		//Envia Paciente a BO
	            	  getHandler().IngresarMedicoCompleto(m);
	              }
	        });
			this.add(botonEnviar);

			//Configuracion de panel
			this.setSize(300,  200);
			this.setLocation(0,20);
			this.setVisible(true);
		}
		
	}
	
	//getters
	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}
	
	public JTextField getTxtConsultorio() {
		return txtConsultorio;
	}

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	//botones
	public JButton getButtonEnviar(){
		return botonEnviar;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}
	
	

