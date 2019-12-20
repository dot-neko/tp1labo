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
				PacientePanel pp = null;
				AltaPanel panel = new AltaPanel(miHandler);
				panel.setActionAlta(pp);
				miHandler.setCustomJPanel(panel,"Alta Pacientes");				
			}
		});
        
        //Panel Baja
        bajapacientes=new JMenuItem("Baja");
        pacientes.add(bajapacientes);
        bajapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PacientePanel pp = null;
				String title ="Baja Pacientes";
				BajaPanel bajapanelpac = new BajaPanel(miHandler);
				bajapanelpac.setAction(pp);
				miHandler.setCustomJPanel(bajapanelpac,title);		
			}
		});
        //Panel Modificacion
        modificacionpacientes=new JMenuItem("Modificacion");
        pacientes.add(modificacionpacientes);
        modificacionpacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PacientePanel pp = null;
				String title ="Modificar Pacientes";
				ModificacionPanel panel = new ModificacionPanel(miHandler);
				panel.setActionSearch(pp);
				panel.setActionUpdate(pp);
				miHandler.setCustomJPanel(panel,title);
			}
		});
        
      //Panel Consulta
        consultapacientes=new JMenuItem("Consulta");
        pacientes.add(consultapacientes);
        consultapacientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				PacientePanel pp = null;
				String title = "Consulta Pacientes";
				ConsultaPanel consultapanel = new ConsultaPanel(miHandler);
				consultapanel.setAction(pp);
				miHandler.setCustomJTable(consultapanel, title);
			}
		});
        
        doctores=new JMenu("Doctores");
        menubar.add(doctores);
        
        
      //Panel Alta Medicos
        
        altamedicos=new JMenuItem("Alta");
        doctores.add(altamedicos);
        altamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MedicoPanel mp = null;
				String title ="Alta Medicos";
				AltaPanel panel = new AltaPanel(miHandler);
				panel.setActionAlta(mp);
				miHandler.setCustomJPanel(panel,title);				
			}
		});
        
        
        //Panel Baja Medicos
        bajamedicos=new JMenuItem("Baja");
        doctores.add(bajamedicos);
        bajamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MedicoPanel mp = null;
				String title ="Baja Medicos";
				BajaPanel bajapanelmed = new BajaPanel(miHandler);
				bajapanelmed.setAction(mp);
				miHandler.setCustomJPanel(bajapanelmed,title);				
			}
		});
        //Panel Modificacion
        modificacionmedicos=new JMenuItem("Modificacion");
        doctores.add(modificacionmedicos);
        modificacionmedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MedicoPanel mp = null;
				String title ="Modificar Medico";
				ModificacionPanel panel = new ModificacionPanel(miHandler);
				panel.setActionSearch(mp);
				panel.setActionUpdate(mp);
				miHandler.setCustomJPanel(panel,title);
			}
		});
        
      //Panel Consulta
        consultamedicos=new JMenuItem("Consulta");
        doctores.add(consultamedicos);
        consultamedicos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				MedicoPanel mp = null;
				String title = "Consulta Medicos";
				ConsultaPanel consultapanel = new ConsultaPanel(miHandler);
				consultapanel.setAction(mp);
				miHandler.setCustomJTable(consultapanel, title);
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
		
		this.setSize(300,  300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//salir al cierre
	}
	
	
	//metodohandler

	public void setHandler(Handler miHandler) {
		System.out.println("Agregando Handler a vista");
		this.miHandler = miHandler;
		
	}
}