package produccion;
/*responsabilidad de la navegacion entre bo y panel*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excepciones.BusinessException;
import ui.*;

//
public class Handler{
	private ActionListener altapaciente,bajapaciente,modificacionpaciente;
	BO miBO;
	MainFrame miFrame;

	
	 public Handler(){
	 }
	 
	 //Aplicacion Principal
	 public void runapp() {
			//Crea BO y JFrame
			BO miBO 	= new BO();
			MainFrame miFrame 	= new MainFrame();

			//crear Handler. Cargarle el BO y el Frame

			this.addBO(miBO);
			this.addMainFrame(miFrame);

			//Cargarle el handler al frame
			miFrame.addHandler(this);

			
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
	
	public void crearPanelModificacion(){
		miFrame.remove(miFrame.getContentPane());
		ModificacionPanel panelmodificacion = new ModificacionPanel();
		
		miFrame.setContentPane(panelmodificacion);
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
        		//Envia Paciente a BO
            	miBO.ValidarPacienteNuevo(documento, nombre, apellido, email);
              }
        };
    	panelalta.getButtonEnviar().addActionListener(altapaciente); 
    }

	public void bajaPaciente(){
		BajaPanel panelbaja= (BajaPanel) miFrame.getContentPane();
		bajapaciente= new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int documento=Integer.valueOf(panelbaja.getTxtDocumento().getText());
				try {
					miBO.validarPacientebyDocumento(documento);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		panelbaja.getBotonBorrar().addActionListener(bajapaciente);
	}
	
	
	public void modificarPaciente(){
		ModificacionPanel panelmodificacion= (ModificacionPanel) miFrame.getContentPane();
		modificacionpaciente= new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int documento=Integer.valueOf(panelmodificacion.getTxtDocumento().getText());
				try {
					miBO.validarPacientebyDocumento(documento);
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		panelmodificacion.getBotonBorrar().addActionListener(modificacionpaciente);
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


