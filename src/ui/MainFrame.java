package ui;

import java.awt.event.*;
import javax.swing.*;

import produccion.Handler;



public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Handler handler;
	
	public MainFrame() {
		JMenuBar menubar;
		JMenu pacientes,doctores,turnos;
	    JMenuItem altapacientes, bajapacientes, modificacionpacientes, consultapacientes;
		//Frame principal
		//Panel principal y opciones
		    
		JPanel panelprincipal = new JPanel();
		menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        
        pacientes=new JMenu("Pacientes");
        menubar.add(pacientes);
        altapacientes=new JMenuItem("Alta");
        pacientes.add(altapacientes);
        altapacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "alta pacientes");
				handler.enviarPacienteNuevo();
				
			}
		});
        
        bajapacientes=new JMenuItem("Baja");
        pacientes.add(bajapacientes);
        
        modificacionpacientes=new JMenuItem("Modificacion");
        pacientes.add(modificacionpacientes);
        
        consultapacientes=new JMenuItem("Consulta");
        pacientes.add(consultapacientes);
        
        doctores=new JMenu("Doctores");
        menubar.add(doctores);
        
        turnos=new JMenu("Turnos");
        menubar.add(turnos);
	    
		JButton botonpacientes = createButton("Pacientes");
		
		botonpacientes.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				//Panel Pacientes
				JPanel panelpacientes = new JPanel();
				JButton botonalta = createButton("Alta");
				botonalta.addActionListener(new ActionListener() {
				
					//Panel Alta Pacientes
					public void actionPerformed(ActionEvent e) {
						//TODO: Handler tiene que crear los paneles
						
					}
				});
				
				panelpacientes.add(createBox().add(botonalta));
				
				//Panel Baja Pacientes
				JButton botonbaja = createButton("Baja");
				panelpacientes.add(createBox().add(botonbaja));

				//handler conoce a todos los paneles
			}
		});
		
		
		//panel principal
		panelprincipal.add(createBox().add(botonpacientes));
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
	
}
