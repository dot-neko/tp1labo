package excepciones;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String TITULO = "ERROR";
	
	public final static String MENSAJE= "Hubo un error en el sistema";
	public final static String GENERICO = "Error";
	public final static String TYPE_SQL = "Error DB";
	public final static String ERRNUMERO = "Es obligatorio ingresar un dato numerico";
	public final static String ERRDB= "El dato no se pudo ingresar en la base de datos";
	public final static String ERRDBGET= "El dato no se pudo obtener de la base de datos";
	public final static String ERRNUMEROINVALIDO = "El numero ingresado es invalido";
	public final static String NOENCONTRADO = "Error al buscar el dato";
	
	public String tipo, msj, title;
	public BusinessException(String title, String message ,String type){
		
		setTitle(title);
		setMsj(message);
		setTipo(type);
	}
	public BusinessException(){

	}
	public String getMsj() {
		return msj;
	}
	public String getTitle() {
		return title;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
