package excepciones;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String TITULO = "ERROR";
	public final static String MENSAJE= "Hubo un error en el sistema";
	public final static String GENERICO = "Error";
	public final static String ERRNUMERO = "Es obligatorio ingresar un dato";
	public final static String NOENCONTRADO = "Error al buscar el dato";
	
	public String tipo, msj, err;
	public BusinessException(String tipo, String msj, String err){

	}
}
