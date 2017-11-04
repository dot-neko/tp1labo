package ui;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import produccion.Handler;



public class MainFrame extends JPanel{
	
	JMenuBar menubar;
	JMenu pacientes,doctores,turnos;
    JMenuItem altapacientes, bajapacientes, modificacionpacientes, consultapacientes;
 
	public MainFrame() {
		
		//Frame principal
		JFrame frameprincial = new JFrame();
		
	    menubar=new JMenuBar();
	    frameprincial.setJMenuBar(menubar);
		//Panel principal y opciones
		
		JPanel panelprincipal = new JPanel();
		frameprincial.setLayout(new BorderLayout());
		frameprincial.setContentPane(panelprincipal);
        
        pacientes=new JMenu("Pacientes");
        menubar.add(pacientes);
        altapacientes=new JMenuItem("Alta");
        pacientes.add(altapacientes);
        altapacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		frameprincial.setSize(500,  300);
		frameprincial.setVisible(true);
		frameprincial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//salir al cierre
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
