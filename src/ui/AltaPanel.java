package ui;

import javax.swing.*;

public class AltaPanel extends JPanel{

private JButton boton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AltaPanel(){
		{
			
			boton= new JButton("Enviar");
			
			this.add(boton);
			this.setSize(500,  300);
			this.setVisible(false);
		}
		
	}
	
	//botones
	public JButton getButton(){
		return boton;
	}
	
}
	
	

