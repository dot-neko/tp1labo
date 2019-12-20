package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import produccion.Handler;

public class AltaPanel extends AbstractPanel{
	private TextboxItem txtDocumento;
	private TextboxItem txtConsultorio;
	private TextboxItem txtNombre;
	private TextboxItem txtApellido;
	private TextboxItem txtEspecialidad;
	private TextboxItem txtEmail;
	private JButton botonEnviar;
	private Handler handler;
	

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public AltaPanel(Handler handler){
		this.handler =handler;
		
		this.add(txtDocumento 	= new TextboxItem("Documento/Matricula", 15));		
		this.add(txtNombre 		= new TextboxItem("Nombre", 20));
		this.add(txtApellido 	= new TextboxItem("Apellido", 20));
		
		botonEnviar= new JButton("Enviar");

		
	}
	
	public void setActionAlta(MedicoPanel panel) {
		this.add(txtConsultorio	= new TextboxItem("Consultorio", 20));
		this.add(txtEspecialidad= new TextboxItem("Especialidad", 20));
		
		botonEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) { 
				String documento= getTxtDocumento();
				String consultorio= getTxtConsultorio();
				String nombre= getTxtNombre();
				String apellido= getTxtApellido();
				String especialidad = getTxtEspecialidad();
				MedicoPanel.buttonCreateMedico(handler, documento, consultorio, nombre, apellido, especialidad);
			}
		});
		this.add(botonEnviar);
	}
	
	public void setActionAlta(PacientePanel panel) {
		this.add(txtEmail = new TextboxItem("Email", 25));
		
		botonEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) { 
				String documento= getTxtDocumento();
				String nombre= getTxtNombre();
				String apellido= getTxtApellido();
				String email = getTxtEmail();
				PacientePanel.buttonCreatePaciente(handler, documento,nombre,apellido,email);
			}
		});
		this.add(botonEnviar);
	}


	//getters
	public String getTxtDocumento() {
		return txtDocumento.getTxtField().getText();
	}

	public String getTxtNombre() {
		return txtNombre.getTxtField().getText();
	}

	public String getTxtApellido() {
		return txtApellido.getTxtField().getText();
	}

	public String getTxtConsultorio() {
		return txtConsultorio.getTxtField().getText();
	}

	public String getTxtEspecialidad() {
		return txtEspecialidad.getTxtField().getText();
	}
	
	public String getTxtEmail() {
		return txtEmail.getTxtField().getText();
	}
	public Handler getHandler() {
		return handler;
	}
}



