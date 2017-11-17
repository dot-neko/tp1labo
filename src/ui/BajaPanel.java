
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entidades.Paciente;
import excepciones.BusinessException;
import produccion.BO;

public class BajaPanel extends JPanel {
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
	public BajaPanel(BO miBO){
		botonBorrar= new JButton("Borrar");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento=new JTextField(15));
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int documento=Integer.valueOf(getTxtDocumento().getText());
				Paciente p= new Paciente(documento);
				try {
					miBO.validarPacientebyDocumento(p);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.add(botonBorrar);
		this.setSize(500,  300);
		this.setLocation(20,100);
		this.setVisible(true);
	}

}


