package Matrix.Exceptions;

public class VectorElementOutOfBoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8419954008557972457L;
	public VectorElementOutOfBoundException () {super();}
	public VectorElementOutOfBoundException(String msg) {super(msg);}
}
