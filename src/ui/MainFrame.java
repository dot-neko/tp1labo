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
	private JMenuItem asignarturnos;
	private AbstractButton crearturnomedico;

	
 
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
				AltaPanelPac panel = new AltaPanelPac(miHandler);
				panel.setAction();
				miHandler.setCustomJPanel(panel,"Alta Pacientes");				
			}
		});
        
        //Panel Baja
        bajapacientes=new JMenuItem("Baja");
        pacientes.add(bajapacientes);
        bajapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String title ="Baja Pacientes";
				BajaPanelPac bajapanelpac = new BajaPanelPac(miHandler);
				bajapanelpac.setAction();
				miHandler.setCustomJPanel(bajapanelpac,title);		
			}
		});
        //Panel Modificacion
        modificacionpacientes=new JMenuItem("Modificacion");
        pacientes.add(modificacionpacientes);
        modificacionpacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String title ="Modificar Pacientes";
				ModificacionPanelPac panel = new ModificacionPanelPac(miHandler);
				panel.setAction();
				miHandler.setCustomJPanel(panel,title);
			}
		});
        
      //Panel Consulta
        consultapacientes=new JMenuItem("Consulta");
        pacientes.add(consultapacientes);
        consultapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String title = "Consulta Pacientes";
				ConsultaPanelPac consultapanel = new ConsultaPanelPac(miHandler);
				consultapanel.setAction();
				miHandler.setCustomJPanel(consultapanel, title);
			}
		});
        
        doctores=new JMenu("Doctores");
        menubar.add(doctores);
        
        
      //Panel Alta Medicos
        
        altamedicos=new JMenuItem("Alta");
        doctores.add(altamedicos);
        altamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String title ="Alta Medicos";
				AltaPanelMed panel = new AltaPanelMed(miHandler);
				panel.setAction();
				miHandler.setCustomJPanel(panel,title);				
			}
		});
        
        
        //Panel Baja Medicos
        bajamedicos=new JMenuItem("Baja");
        doctores.add(bajamedicos);
        bajamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String title ="Baja Medicos";
				BajaPanelMed bajapanelmed = new BajaPanelMed(miHandler);
				bajapanelmed.setAction();
				miHandler.setCustomJPanel(bajapanelmed,title);				
			}
		});
        //Panel Modificacion
        modificacionmedicos=new JMenuItem("Modificacion");
        doctores.add(modificacionmedicos);
        modificacionmedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String title ="Modificar Medico";
				ModificacionPanelMed panel = new ModificacionPanelMed(miHandler);
				panel.setAction();
				miHandler.setCustomJPanel(panel,title);
			}
		});
        
      //Panel Consulta
        consultamedicos=new JMenuItem("Consulta");
        doctores.add(consultamedicos);
        consultamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String title = "Consulta Medicos";
				ConsultaPanelMed consultapanel = new ConsultaPanelMed(miHandler);
				consultapanel.setAction();
				miHandler.setCustomJPanel(consultapanel, title);
			}
		});
        
      //Panel Crear Turnos Medico
        crearturnomedico=new JMenuItem("Crear nuevos turnos");
        doctores.add(crearturnomedico);
        crearturnomedico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.setCustomJPanel(new CrearTurnosPanel(miHandler),"Creación Turnos");
				
			}
		});
        
        //TURNOS
        turnos=new JMenu("Turnos");
        menubar.add(turnos);
        
        
        asignarturnos=new JMenuItem("Asignar Turnos Nuevos");
        turnos.add(asignarturnos);
        asignarturnos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				miHandler.setCustomJPanel(new AsignarTurnosPanel(miHandler),"Asignar Turnos");
			}
		});
        //FIN Jmenubar
		
		
		//Parametros JFrame
		
		this.setSize(600,  400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//salir al cierre
	}
	
	
	//metodohandler

	public void setHandler(Handler miHandler) {
		System.out.println("Agregando Handler a vista");
		this.miHandler = miHandler;
		
	}
}