package ui;

import java.awt.event.*;
import javax.swing.*;

import produccion.Handler;



public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Handler miHandler;
	JMenuBar menubar;
	JMenu pacientes,doctores,turnos;
    JMenuItem altapacientes, bajapacientes, modificacionpacientes, consultapacientes;
 
	public MainFrame() {
		
		//Frame principal
		
	    menubar=new JMenuBar();
	    this.setJMenuBar(menubar);
		//JmenuBar
        pacientes=new JMenu("Pacientes");
        menubar.add(pacientes);
        
        //Panel Alta
        altapacientes=new JMenuItem("Alta");
        pacientes.add(altapacientes);
        altapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelAlta();
			}
		});
        //Panel Baja
        bajapacientes=new JMenuItem("Baja");
        pacientes.add(bajapacientes);
        bajapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelBaja();
			}
		});
        //Panel Modificacion
        modificacionpacientes=new JMenuItem("Modificacion");
        pacientes.add(modificacionpacientes);
        modificacionpacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelModificacion();
			}
		});
        
        //Panel Consulta
        consultapacientes=new JMenuItem("Consulta");
        pacientes.add(consultapacientes);
        consultapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelConsulta();
				
			}
		});
        
        doctores=new JMenu("Doctores");
        menubar.add(doctores);
        
        turnos=new JMenu("Turnos");
        menubar.add(turnos);
        
        //FIN Jmenubar
		
		
		//Parametros JFrame
		
		this.setSize(500,  300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//salir al cierre
	}
	
	
	//metodohandler

	public void setHandler(Handler miHandler) {
		System.out.println("Agregando Handler a vista");
		this.miHandler = miHandler;
		
	}

	
	//METODOS AUXILIARES
	
}