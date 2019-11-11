package entidades;

public class Paciente {
	private String documento;
	private String nombre;
	private String apellido;
	private String email;
	
	public Paciente(String documento, String nombre, String apellido, String email){
		setDocumento(documento);
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
	}
	
	public Paciente(String documento){
		setDocumento(documento);
	}
	public String getEmail() {
		return email;
	}
	public String getDocumento() {
		return documento;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
