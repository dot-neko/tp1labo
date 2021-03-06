package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import entidades.Paciente;
import produccion.Handler;

public class ModificacionPanelPac extends PacientePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TextboxItem txtNombreInput;
	private TextboxItem txtApellidoInput;
	private TextboxItem txtEmailInput;

	private TextboxItem txtDocumentoSearch;
	private JButton botonBuscar;

	private JButton botonActualizar;




	public ModificacionPanelPac(Handler handler) {
		super(handler);
		botonBuscar = new JButton("Buscar");
		botonActualizar = new JButton("Actualizar");


		this.add(txtDocumentoSearch 	= new TextboxItem("Documento", 15));	
		this.add(botonBuscar);


		this.add(txtNombreInput = new TextboxItem("Nombre", 20));
		this.add(txtApellidoInput = new TextboxItem("Apellido", 20));


	}
	
	public void setAction() {
		this.add(txtEmailInput = new TextboxItem("Email", 25));
		botonBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//Voy a buscar
				String documento = getTxtDocumento().getText();
				Paciente p = buttonSearchPac(documento);

				//Pego los valores
				getTxtNombreInput().setText(p.getNombre());
				getTxtApellidoInput().setText(p.getApellido());
				getTxtDocumento().setText(String.valueOf(p.getDocumento()));
				getTxtEmailInput().setText(p.getEmail());
			}
		});
		
		botonActualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String documento= getTxtDocumento().getText();
				String nombre= getTxtNombreInput().getText();
				String apellido= getTxtApellidoInput().getText();
				String email = getTxtEmailInput().getText();
				buttonUpdatePac(documento, nombre, apellido, email);
				
				//Set null una vez actualizado
				getTxtNombreInput().setText(null);
				getTxtApellidoInput().setText(null);
				getTxtDocumento().setText(null);
				getTxtEmailInput().setText(null);
			}
		});

		this.add(botonActualizar);
		this.add(agregarSalirButton());
	}
	
	public JTextField getTxtDocumento() {
		return txtDocumentoSearch.getTxtField();
	}

	public JTextField getTxtNombreInput() {
		return txtNombreInput.getTxtField();
	}

	public JTextField getTxtApellidoInput() {
		return txtApellidoInput.getTxtField();
	}
	
	public JTextField getTxtEmailInput() {
		return txtEmailInput.getTxtField();
	}
}
