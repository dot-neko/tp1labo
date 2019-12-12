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

public class ModificacionPanelMedico extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Handler handler;

	private JTextField txtConsultorioInput;
	private JTextField txtNombreInput;
	private JTextField txtApellidoInput;
	private JTextField txtEspecialidadInput;

	private JTextField txtDocumentoSearch;
	private JButton botonBuscar;
	
	private JButton botonActualizar;


	

	public ModificacionPanelMedico(Handler handler) {
		this.handler=handler;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		botonBuscar = new JButton("Buscar");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumentoSearch = new JTextField(15));
		txtDocumentoSearch.setMaximumSize(txtDocumentoSearch.getPreferredSize());
		
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Voy a buscar paciente
				String documento=getTxtDocumento().getText();
				Medico m= new Medico(documento);
				m=getHandler().buscarMedico(m);
				
				//Pego los valores
				getTxtNombreInput().setText(m.getNombre());
				getTxtConsultorioInput().setText(m.getConsultorio());
				getTxtApellidoInput().setText(m.getApellido());
				getTxtDocumento().setText(String.valueOf(m.getDocumento()));
				getTxtEspecialidadInput().setText(m.getEspecialidad());
					

			}
		});
		this.add(botonBuscar);
		
		//devolucion;
		botonActualizar = new JButton("Actualizar");

		this.add(new JLabel("Consultorio :"));
		this.add(txtConsultorioInput= new JTextField(15));
		txtConsultorioInput.setMaximumSize(txtConsultorioInput.getPreferredSize());
		
		this.add(new JLabel("Nombre :"));
		this.add(txtNombreInput= new JTextField(20));
		txtNombreInput.setMaximumSize(txtNombreInput.getPreferredSize());
		
		this.add(new JLabel("Apellido :"));
		this.add(txtApellidoInput= new JTextField(20));
		txtApellidoInput.setMaximumSize(txtApellidoInput.getPreferredSize());
		
		this.add(new JLabel("Email :"));
		this.add(txtEspecialidadInput= new JTextField(30));
		txtEspecialidadInput.setMaximumSize(txtEspecialidadInput.getPreferredSize());
		
		botonActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String documento= getTxtDocumento().getText();
				String consultorio= getTxtConsultorioInput().getText();
        		String nombre= getTxtNombreInput().getText();
        		String apellido= getTxtApellidoInput().getText();
        		String especalidad = getTxtEspecialidadInput().getText();
        		Medico m= new Medico(documento,consultorio, nombre, apellido,especalidad);
        		//Envia el paciente a actualizar
        		getHandler().actualizarMedico(m);
        		//Set null una vez actualizado
        		getTxtNombreInput().setText(null);
        		getTxtConsultorioInput().setText(null);
				getTxtApellidoInput().setText(null);
				getTxtDocumento().setText(null);
				getTxtEspecialidadInput().setText(null);
			}
		});
		
		this.add(botonActualizar);
		this.setSize(500, 300);
		this.setLocation(20, 100);


	}

	public JTextField getTxtDocumento() {
		return txtDocumentoSearch;
	}

	public JTextField getTxtNombreInput() {
		return txtNombreInput;
	}

	public JTextField getTxtApellidoInput() {
		return txtApellidoInput;
	}
	
	public JTextField getTxtConsultorioInput() {
		return txtConsultorioInput;
	}


	public JTextField getTxtEspecialidadInput() {
		return txtEspecialidadInput;
	}


	public Handler getHandler() {
		return handler;
	}
}
