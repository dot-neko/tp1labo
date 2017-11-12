
package ui;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import produccion.Handler;

public class BajaPanel extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	//VARIABLES LOCALES
	private JTextField txtDocumento;
	private JButton botonEnviar, botonSalir;
	
	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	//CONSTRUCTOR
	public BajaPanel(){
		botonEnviar= new JButton("Enviar");
		botonSalir= new JButton("Salir");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento=new JTextField(15));
		
		this.add(botonEnviar);
		this.add(botonSalir);

		this.setSize(500,  300);
		this.setLocation(20,100);
		this.setVisible(true);
	}

}


