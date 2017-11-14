
package ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BajaPanel extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	//VARIABLES LOCALES
	private JTextField txtDocumento;
	private JButton botonBorrar, botonSalir;
	
	public JButton getBotonBorrar() {
		return botonBorrar;
	}
	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	//CONSTRUCTOR
	public BajaPanel(){
		botonBorrar= new JButton("Borrar");
		botonSalir= new JButton("Salir");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento=new JTextField(15));
		
		this.add(botonBorrar);
		this.add(botonSalir);

		this.setSize(500,  300);
		this.setLocation(20,100);
		this.setVisible(true);
	}

}


