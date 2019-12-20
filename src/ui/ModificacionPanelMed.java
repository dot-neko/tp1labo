package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import entidades.Medico;
import produccion.Handler;

public class ModificacionPanelMed extends MedicoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TextboxItem txtConsultorioInput;
	private TextboxItem txtNombreInput;
	private TextboxItem txtApellidoInput;
	private TextboxItem txtEspecialidadInput;

	private TextboxItem txtDocumentoSearch;
	private JButton botonBuscar;

	private JButton botonActualizar;




	public ModificacionPanelMed(Handler handler) {
		super(handler);
		botonBuscar = new JButton("Buscar");
		botonActualizar = new JButton("Actualizar");


		this.add(txtDocumentoSearch 	= new TextboxItem("Documento/Matricula", 15));	
		this.add(botonBuscar);


		this.add(txtNombreInput = new TextboxItem("Nombre", 20));
		this.add(txtApellidoInput = new TextboxItem("Apellido", 20));


	}
	
	public void setAction() {
		this.add(txtConsultorioInput = new TextboxItem("Consultorio", 15));
		this.add(txtEspecialidadInput = new TextboxItem("Especialidad", 20));	
		botonBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//Voy a buscar
				String documento = getTxtDocumento().getText();
				Medico m = buttonSearchMed(documento);

				//Pego los valores
				getTxtNombreInput().setText(m.getNombre());
				getTxtConsultorioInput().setText(m.getConsultorio());
				getTxtApellidoInput().setText(m.getApellido());
				getTxtDocumento().setText(String.valueOf(m.getDocumento()));
				getTxtEspecialidadInput().setText(m.getEspecialidad());
			}
		});
	
		botonActualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String documento= getTxtDocumento().getText();
				String consultorio= getTxtConsultorioInput().getText();
				String nombre= getTxtNombreInput().getText();
				String apellido= getTxtApellidoInput().getText();
				String especalidad = getTxtEspecialidadInput().getText();
				buttonUpdateMedico(documento,consultorio, nombre, apellido,especalidad);
				
				//Set null una vez actualizado
				getTxtNombreInput().setText(null);
				getTxtConsultorioInput().setText(null);
				getTxtApellidoInput().setText(null);
				getTxtDocumento().setText(null);
				getTxtEspecialidadInput().setText(null);
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

	public JTextField getTxtConsultorioInput() {
		return txtConsultorioInput.getTxtField();
	}


	public JTextField getTxtEspecialidadInput() {
		return txtEspecialidadInput.getTxtField();
	}


}
