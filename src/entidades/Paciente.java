package entidades;

public class Paciente {
	private String documento;
	private String nombre;
	private String apellido;
	private String email;
	
	public Paciente(String doc, String nom, String ape, String email){
		setDocumento(doc);
		setNombre(nom);
		setApellido(ape);
		setEmail(email);
	}
	
	public Paciente(String doc){
		setDocumento(doc);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
}
