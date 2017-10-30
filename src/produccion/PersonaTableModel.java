package produccion;

import java.util.*;
import entidades.*;

import javax.swing.table.AbstractTableModel;

public class PersonaTableModel extends AbstractTableModel {
	
	private List<Pacientes> paciente_list;
	private static final int DNI=0;				//static garantiza que el garbagecollector no toque la variable- final no cambiar el valor
	private static final int NOMBRE=1;			//con este alias evito forzar el orden de los elementos en la tabla.
	private static final int APELLIDO=2;
	private String TITLES[]={"DNI","NOMBRE","APELLIDO"};
	
	
	public Object getValueAt(int row, int col){
		Pacientes p= paciente_list.get(row);
		switch(col){
		case DNI: return p.getDocumento();
		case NOMBRE: return p.getNombre();
		case APELLIDO: return p.getApellido();
		
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
		return paciente_list.size();
	}
	
	
	//Editar
	
	public Pacientes getPersona(int row){
		return paciente_list.get(row);
		
	}
	
	
	
	
	



}
