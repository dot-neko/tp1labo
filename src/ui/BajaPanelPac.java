package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import produccion.Handler;



public class BajaPanelPac extends PacientePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonBorrar;
	private TextboxItem textpanel;
	private String label= "Documento";

	public BajaPanelPac(Handler handler) {
		super(handler);
		textpanel =new TextboxItem(label,15);
		this.add(textpanel);
		botonBorrar = new JButton("Borrar");
		this.add(botonBorrar);
		this.add(agregarSalirButton());
	}	

	@Override
	public void setAction() {
		botonBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String documento=textpanel.getTxtField().getText();
				buttonDeleteAction(documento);
			}
		});
	}


	@Override
	public void buttonCreateAction(String documento, String consultorio, String nombre, String apellido,
			String especialidad) {
		// TODO Auto-generated method stub
		
	}
}
