
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Paciente;
import excepciones.BusinessException;
import produccion.Handler;

public class BajaPanelPaciente extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	//VARIABLES LOCALES
	private JTextField txtDocumento;
	private JButton botonBorrar;
	

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	//CONSTRUCTOR
	public BajaPanelPaciente(Handler handler){
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		botonBorrar= new JButton("Borrar");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento=new JTextField(15));
		txtDocumento.setMaximumSize(txtDocumento.getPreferredSize());
		
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String documento=getTxtDocumento().getText();
				Paciente p= new Paciente(documento);
				try {
					handler.getBO().validarPacientebyDocumento(p);
				} catch (BusinessException e1) {
					handler.HandleBusinessException(e1);
				}
			}
		});
		this.add(botonBorrar);
		this.setSize(500,  300);
		this.setLocation(20,100);
		this.setVisible(true);
	}

}


