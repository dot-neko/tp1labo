package ui;

import java.util.*;
import entidades.*;

import javax.swing.table.AbstractTableModel;

public class PacienteTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Paciente> paciente_list;
	private static final ArrayList<String> titulos= new ArrayList<String>();//prueba
	private static final int DNI=0;				//static garantiza que el garbagecollector no toque la variable- final no cambiar el valor
	private static final int NOMBRE=1;			//con este alias evito forzar el orden de los elementos en la tabla.
	private static final int APELLIDO=2;
	private static final int EMAIL=3;
	private String TITLES[]={"DNI","NOMBRE","APELLIDO","EMAIL"};
	
	
	public PacienteTableModel(List<Paciente> listadoPacientes) {
		
		paciente_list = listadoPacientes;
	}

	public Object getValueAt(int row, int col){
		Paciente pac= paciente_list.get(row);
		switch(col){
			case DNI: return pac.getDocumento();
			case NOMBRE: return pac.getNombre();
			case APELLIDO: return pac.getApellido();
			case EMAIL: return pac.getEmail();
		
		}
		return null;
	}
	
	public String getColumnName(int col){		//Header de la columna
		return TITLES [col];
	}
	
	public int getColumnCount(){
		return TITLES.length;
	}
	
	public int getRowCount(){
		if (paciente_list != null){
			return paciente_list.size();
		}else{
			return 0;
		}
	}
	
	

	
	
	
	
	



}
