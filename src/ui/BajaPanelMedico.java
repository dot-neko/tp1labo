
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

public class BajaPanelMedico extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	//VARIABLES LOCALES
	private JTextField txtDocumento;
	private JButton botonBorrar;
	private Handler handler;
	

	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	//CONSTRUCTOR
	public BajaPanelMedico(){
		
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		botonBorrar= new JButton("Borrar");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento=new JTextField(15));
		txtDocumento.setMaximumSize(txtDocumento.getPreferredSize());
		
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String documento=getTxtDocumento().getText();
				Medico m= new Medico(documento);
				getHandler().borrarMedicoByDocumento(m);
			}
		});
		this.add(botonBorrar);
		this.setSize(500,  300);
		this.setLocation(20,100);
		this.setVisible(true);
	}

	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}


