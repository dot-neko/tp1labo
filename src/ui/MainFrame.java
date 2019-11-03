package ui;

import java.awt.event.*;
import javax.swing.*;

import produccion.Handler;



public class MainFrame extends JFrame{


	private static final long serialVersionUID = 1L;
	private static final int Pacientes=0;				
	private static final int Doctores=1;		
	private static final int Turnos=2;
	private String titulos[]={"Pacientes","Doctores","Turnos"};
	private static final int Alta=0;				
	private static final int Baja=1;		
	private static final int Modificacion=2;
	private static final int Consulta=3;
	private String tituloPanel[]={"Alta","Baja","Modificacion","Consulta"};
	private Handler miHandler;


	public MainFrame() {


		//Frame principal		
		this.setJMenuBar(new JMenuBar());

		//JmenuBar
		this.getJMenuBar().add(new JMenu(titulos[Pacientes]),Pacientes);
		this.getJMenuBar().add(new JMenu(titulos[Doctores]),Doctores);
		this.getJMenuBar().add(new JMenu(titulos[Turnos]),Turnos);

		//FIN Jmenubar

		//Panel Alta
		getJMenu(Pacientes).add(new JMenuItem("Alta")).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getMiHandler().crearPanel(titulos[Pacientes],tituloPanel[Alta]);
			}
		});
		//Panel Baja
		getJMenu(Pacientes).add(new JMenuItem("Baja")).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getMiHandler().crearPanel(titulos[Pacientes],tituloPanel[Baja]);
			}
		});

		//Panel Modificacion
		getJMenu(Pacientes).add(new JMenuItem("Modificacion")).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getMiHandler().crearPanel(titulos[Pacientes],tituloPanel[Modificacion]);
			}
		});

		//Panel Consulta
		getJMenu(Pacientes).add(new JMenuItem("Consulta")).addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				getMiHandler().crearPanel(titulos[Pacientes],tituloPanel[Consulta]);
			}
		});


		//Parametros JFrame

		this.setSize(600,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//metodohandler

	public Handler getMiHandler() {
		return miHandler;
	}

	public void addHandler(Handler miHandler) {
		System.out.println("Agregando Handler a vista");
		this.miHandler = miHandler;
	}

	public JMenu getJMenu(int index) {
		return getJMenuBar().getMenu(index);
	}
}







//METODOS AUXILIARES


