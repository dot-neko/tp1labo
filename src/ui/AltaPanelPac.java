package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import produccion.Handler;

public class AltaPanelPac extends PacientePanel{
	private TextboxItem txtDocumento;
	private TextboxItem txtNombre;
	private TextboxItem txtApellido;
	private TextboxItem txtEmail;
	private JButton botonEnviar;
	

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public AltaPanelPac(Handler handler){
		super(handler);
		
		this.add(txtDocumento 	= new TextboxItem("Documento", 15));		
		this.add(txtNombre 		= new TextboxItem("Nombre", 20));
		this.add(txtApellido 	= new TextboxItem("Apellido", 20));
		
		botonEnviar= new JButton("Enviar");
	}
	
	public void setAction() {
		this.add(txtEmail = new TextboxItem("Email", 25));
		
		botonEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent actionEvent) { 
				String documento= getTxtDocumento();
				String nombre= getTxtNombre();
				String apellido= getTxtApellido();
				String email = getTxtEmail();
				buttonCreateAction(documento,nombre,apellido,email);
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

	public String getTxtEmail() {
		return txtEmail.getTxtField().getText();
	}



}



