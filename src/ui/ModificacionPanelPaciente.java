package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Paciente;
import produccion.Handler;

public class ModificacionPanelPaciente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Handler handler;
	private JTextField txtNombreInput;
	private JTextField txtApellidoInput;
	private JTextField txtEmailInput;
	private JTextField txtDocumento;
	private JButton botonBuscar;
	private JButton botonActualizar;


	

	public ModificacionPanelPaciente(Handler handler) {
		this.handler =handler;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		botonBuscar = new JButton("Buscar");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento = new JTextField(15));
		txtDocumento.setMaximumSize(txtDocumento.getPreferredSize());
		
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Voy a buscar paciente
				String documento=getTxtDocumento().getText();
				Paciente p= new Paciente(documento);
				p=getHandler().buscarPaciente(p);
				getTxtNombreInput().setText(p.getNombre());
				getTxtApellidoInput().setText(p.getApellido());
				getTxtEmailInput().setText(p.getEmail());
			}
		});
		this.add(botonBuscar);
		
		//devolucion;
		botonActualizar = new JButton("Actualizar");
		
		this.add(new JLabel("Nombre :"));
		this.add(txtNombreInput= new JTextField(20));
		txtNombreInput.setMaximumSize(txtNombreInput.getPreferredSize());
		
		this.add(new JLabel("Apellido :"));
		this.add(txtApellidoInput= new JTextField(20));
		txtApellidoInput.setMaximumSize(txtApellidoInput.getPreferredSize());
		
		this.add(new JLabel("Email :"));
		this.add(txtEmailInput= new JTextField(30));
		txtEmailInput.setMaximumSize(txtEmailInput.getPreferredSize());
		
		botonActualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String documento= getTxtDocumento().getText();
        		String nombre= getTxtNombreInput().getText();
        		String apellido= getTxtApellidoInput().getText();
        		String email = getTxtEmailInput().getText();
        		Paciente p= new Paciente(documento,nombre,apellido,email);
        		getHandler().actualizarPaciente(p);
        		//Set null una vez actualizado
        		getTxtNombreInput().setText(null);
				getTxtApellidoInput().setText(null);
				getTxtDocumento().setText(null);
				getTxtEmailInput().setText(null);
			}
		});
		
		this.add(botonActualizar);
		this.setSize(500, 300);
		this.setLocation(20, 100);


	}



	public JTextField getTxtNombreInput() {
		return txtNombreInput;
	}

	public JTextField getTxtApellidoInput() {
		return txtApellidoInput;
	}

	public JTextField getTxtEmailInput() {
		return txtEmailInput;
	}

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	public Handler getHandler() {
		return handler;
	}

}
