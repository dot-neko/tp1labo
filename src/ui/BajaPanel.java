package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import produccion.Handler;



public class BajaPanel extends AbstractPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonBorrar;
	private JTextField txtDocumento;
	private String label= "Documento/Matricula";
	private Handler handler;

	public BajaPanel(Handler handler) {
		this.handler=handler;
		this.add(new JLabel(label + " :"));
		
		this.add(txtDocumento=new JTextField(15));
		txtDocumento.setMaximumSize(txtDocumento.getPreferredSize());
		
		botonBorrar = new JButton("Borrar");
		this.add(botonBorrar);
	}	

	public void setAction(MedicoPanel mp) {
		botonBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String documento=getTxtDocumento().getText();
				MedicoPanel.buttonDeleteAction(handler, documento);
			}
		});
	}

	public void setAction(PacientePanel pp) {
		botonBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String documento=getTxtDocumento().getText();
				PacientePanel.buttonDeleteAction(handler,documento);
			}
		});
	}
	
	public JTextField getTxtDocumento() {
		return txtDocumento;
	}

	public Handler getHandler() {
		return handler;
	}

}
