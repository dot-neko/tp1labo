package entidades;

public class Medico {
	private String documento;
	private String consultorio;
	private String nombre;
	private String apellido;
	private String especialidad;
	
	public Medico(String documento, String consultorio, String nombre, String apellido, String especialidad){
		this.documento=documento;
		this.consultorio=consultorio;
		this.nombre=nombre;
		this.apellido=apellido;
		this.especialidad=especialidad;
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
