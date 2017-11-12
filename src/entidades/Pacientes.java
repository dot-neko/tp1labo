package entidades;

public class Pacientes {
	private int documento;
	private String nombre;
	private String apellido;
	private String email;
	
	public Pacientes(int doc, String nom, String ape, String email){
		setNombre(nom);
		setApellido(ape);
		setDocumento(doc);
		setEmail(email);
	}
	public Pacientes() {
		// TODO Auto-generated constructor stub
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
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
}
