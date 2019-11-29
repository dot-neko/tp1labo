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
	private JMenuItem altamedicos;
	private JMenuItem bajamedicos;
	private JMenuItem consultamedicos;
	private JMenuItem modificacionmedicos;
 
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
				miHandler.crearPanelAltaPaciente();
			}
		});
        //Panel Baja
        bajapacientes=new JMenuItem("Baja");
        pacientes.add(bajapacientes);
        bajapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelBajaPaciente();
			}
		});
        //Panel Modificacion
        modificacionpacientes=new JMenuItem("Modificacion");
        pacientes.add(modificacionpacientes);
        modificacionpacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelModificacionPaciente();
			}
		});
        
        //Panel Consulta
        consultapacientes=new JMenuItem("Consulta");
        pacientes.add(consultapacientes);
        consultapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelConsultaPaciente();
				
			}
		});
        
        doctores=new JMenu("Doctores");
        menubar.add(doctores);
        
        
      //Panel Alta Medicos
        altamedicos=new JMenuItem("Alta");
        doctores.add(altamedicos);
        altamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelAltaMedico();
			}
		});
        //Panel Baja
        bajamedicos=new JMenuItem("Baja");
        doctores.add(bajamedicos);
        bajamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelBajaMedico();
			}
		});
        //Panel Modificacion
        modificacionmedicos=new JMenuItem("Modificacion");
        doctores.add(modificacionmedicos);
        modificacionmedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelModificacionMedico();
			}
		});
        
        //Panel Consulta
        consultamedicos=new JMenuItem("Consulta");
        doctores.add(consultamedicos);
        consultamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelConsultaMedico();
				
			}
		});
        
        //TURNOS
        turnos=new JMenu("Turnos");
        menubar.add(turnos);
        
        //FIN Jmenubar
		
		
		//Parametros JFrame
		
		this.setSize(300,  300);
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