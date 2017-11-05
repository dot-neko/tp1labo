package ui;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import produccion.Handler;



public class MainFrame extends JFrame{
	Handler miHandler;
	JMenuBar menubar;
	JMenu pacientes,doctores,turnos;
    JMenuItem altapacientes, bajapacientes, modificacionpacientes, consultapacientes;
 
	public MainFrame() {
		
		//Frame principal
		
	    menubar=new JMenuBar();
	    this.setJMenuBar(menubar);
	    
		//Panel principal y opciones
		JPanel panelprincipal = new JPanel();
        this.setContentPane(panelprincipal);
        pacientes=new JMenu("Pacientes");
        menubar.add(pacientes);
        altapacientes=new JMenuItem("Alta");
        pacientes.add(altapacientes);
        altapacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				miHandler.crearPanelAlta();
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
	
		
		//panel principal
		panelprincipal.setSize(500,  300);
		panelprincipal.setVisible(true);
		
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


	public void addHandler(Handler miHandler) {
		System.out.println("Agregando Handler a vista");
		this.miHandler = miHandler;
		
	}

	
	//METODOS AUXILIARES
	
}
