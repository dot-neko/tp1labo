package ui;

import java.awt.event.*;
import javax.swing.*;

import produccion.Handler;



public class MainFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 	public Handler handler = new Handler();
	public void setHandler(Handler handler) {
		this.handler = handler;
	}


	public MainFrame() {
		
		//Frame principal
		//Panel principal y opciones
		Handler handler = new Handler();
		JPanel panelprincipal = new JPanel();
		JButton botonpacientes = createButton("Pacientes");
		panelprincipal.add(createBox().add(botonpacientes));
		botonpacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Panel Pacientes
				JPanel panelpacientes = new JPanel();
				JButton botonalta = createButton("Alta");
				panelpacientes.add(createBox().add(botonalta));
				botonalta.addActionListener(new ActionListener() {
					
					//Panel Alta Pacientes
					public void actionPerformed(ActionEvent e) {
						AltaPanel panelaltapacientes = new AltaPanel();
						handler.setPanelAlta(panelaltapacientes);
						handler.enviarPacienteNuevo();
						matapaneles(panelpacientes);
						agregapaneles(panelaltapacientes);
					}
				});
				
				//Panel Baja Pacientes
				JButton botonbaja = createButton("Baja");
				panelpacientes.add(createBox().add(botonbaja));
				matapaneles(panelprincipal);
				agregapaneles(panelpacientes);
				//handler conoce a todos los paneles
			}
		});
		
		
		//panel principal
		panelprincipal.setSize(500,  300);
		panelprincipal.setVisible(true);
		this.add(panelprincipal);
		//Parametros JFrame
		this.setSize(500,  300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//salir al cierre
	}
	
	
	//botones
	private Box createBox() {
		Box box = Box.createHorizontalBox();
		box.add(Box.createHorizontalGlue());
		return box;
	}
	private JButton createButton(String buttonlabel) {
		JButton buttonlabel1 = new JButton(buttonlabel);
		return buttonlabel1;
	}
	
	//METODOS AUXILIARES
	

	private void matapaneles(JPanel panel){
		this.remove(panel);
		this.revalidate();
	}
	private void agregapaneles(JPanel panel){
		panel.setSize(500,  300);
		panel.setVisible(true);
		this.add(panel);
		this.revalidate();
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
