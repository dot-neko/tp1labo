package produccion;
/*responsabilidad de la navegacion entre bo y panel*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.*;

//
public class Handler{
	private ActionListener altapaciente,cerrarpanel;
	BO miBO;
	MainFrame miFrame;

	
	 public Handler(){
	 }
	//Declaro paneles

	public void crearPanelAlta(){
		miFrame.remove(miFrame.getContentPane());
		AltaPanel panelalta = new AltaPanel();
		miFrame.setContentPane(panelalta);
		miFrame.setTitle("Alta Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelBaja(){
		miFrame.remove(miFrame.getContentPane());
		BajaPanel panelbaja = new BajaPanel();
		miFrame.setContentPane(panelbaja);
		miFrame.setTitle("Baja Pacientes");
		miFrame.repaint();
	}
	
	public void crearPanelConsulta(){
		miFrame.remove(miFrame.getContentPane());
		ConsultaPanel panelconsulta = new ConsultaPanel(miBO.getAllPacientes());
		
		miFrame.setContentPane(panelconsulta);
		miFrame.setTitle("Consulta Pacientes");
		miFrame.revalidate();
		miFrame.repaint();
	}

	//Agrego listener a botones paneles
	public void AltaPaciente(){     
		AltaPanel panelalta= (AltaPanel) miFrame.getContentPane();
		altapaciente = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) { 
          		int documento= Integer.valueOf(panelalta.getTxtDocumento().getText()) ;
        		String nombre= panelalta.getTxtNombre().getText();
        		String apellido= panelalta.getTxtApellido().getText();
        		String email = panelalta.getTxtEmail().getText();
            	miBO.ValidarPacienteNuevo(documento, nombre, apellido, email);
              }
        };
        cerrarpanel = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarPanel();
			}
		};
    	panelalta.getButtonEnviar().addActionListener(altapaciente); 
    	panelalta.getButtonSalir().addActionListener(cerrarpanel);
    }

	public void cerrarPanel(){

	}
	

	// metodos para agregar frame y bo
	public void addMainFrame(MainFrame miFrame) {
		System.out.println("Agregando Frame a Handler");
		this.miFrame = miFrame;
		
	}
	public void addBO(BO miBO) {
		System.out.println("Agregando BO a Handler");
		this.miBO = miBO;
	}
	
	
}


