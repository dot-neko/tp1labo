package entidades;

public class Medico {
	private String documento;
	private String consultorio;
	private String nombre;
	private String apellido;
	private String especialidad;
	
	public Medico(String documento, String consultorio, String nombre, String apellido, String especialidad){
		setDocumento(documento);
		setConsultorio(consultorio);
		setNombre(nombre);
		setApellido(apellido);
		setEspecialidad(especialidad);
	}
	public Medico(String documento) {
		setDocumento(documento);
	}
	public String getConsultorio(){
		return consultorio;
	}
	public String getDocumento() {
		return documento;
	}
	private void setDocumento(String documento) {
		this.documento=documento;
	}
	private void setConsultorio(String consultorio){
		this.consultorio=consultorio;
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
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEspecialidad() {
		return especialidad;
	}
}
