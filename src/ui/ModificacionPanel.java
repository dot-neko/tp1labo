package ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Pacientes;




public class ModificacionPanel extends JPanel {
	private JTextField txtDocumento;
	private JButton botonBorrar;
	
	public JButton getBotonBorrar() {
		return botonBorrar;
	}
	public JTextField getTxtDocumento() {
		return txtDocumento;
	}
	public ModificacionPanel(){
		botonBorrar= new JButton("Borrar");
		this.add(new JLabel("Documento : "));
		this.add(txtDocumento=new JTextField(15));
		
		this.add(botonBorrar);
		this.setSize(500,  300);
		this.setLocation(20,100);
		this.setVisible(true);
	}
	}
	
	

