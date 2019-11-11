package entidades;

public class Medico {
	private String documento;
	private String nombre;
	private String apellido;
	private String especialidad;
//TODO: Clase medicos faltante
	public Medicos(String documento, String nombre, String apellido, String especialidad){
		setDocumento(documento);
		setNombre(nombre);
		setApellido(apellido);
		setEspecialidad(especialidad);
	}
	public String getDocumento(){
		return documento;
	}
	private void setDocumento(String documento){
		this.documento=documento;
	}
	private void setNombre(String nombre){
		this.nombre=nombre;
	}
	private void setApellido(String apellido){
		this.apellido=apellido;
	}
	private void setEspecialidad(String especialidad){
		this.especialidad=especialidad;
	}
}
