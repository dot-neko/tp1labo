package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import produccion.Handler;

public class AltaPanelMed extends MedicoPanel{
	private TextboxItem txtDocumento;
	private TextboxItem txtConsultorio;
	private TextboxItem txtNombre;
	private TextboxItem txtApellido;
	private TextboxItem txtEspecialidad;
	private JButton botonEnviar;


	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public AltaPanelMed(Handler handler){
		super(handler);

		this.add(txtDocumento 	= new TextboxItem("Matricula", 15));		
		this.add(txtNombre 		= new TextboxItem("Nombre", 20));
		this.add(txtApellido 	= new TextboxItem("Apellido", 20));

		botonEnviar= new JButton("Enviar");
	}
	@Override
	public void setAction() {
		this.add(txtConsultorio	= new TextboxItem("Consultorio", 20));
		this.add(txtEspecialidad= new TextboxItem("Especialidad", 20));

		botonEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) { 
				String documento= getTxtDocumento();
				String consultorio= getTxtConsultorio();
				String nombre= getTxtNombre();
				String apellido= getTxtApellido();
				String especialidad = getTxtEspecialidad();
				buttonCreateAction(documento, consultorio, nombre, apellido, especialidad);
			}
		});
		this.add(botonEnviar);
		this.add(agregarSalirButton());
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

}



