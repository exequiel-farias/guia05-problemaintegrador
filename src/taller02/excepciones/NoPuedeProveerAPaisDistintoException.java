package taller02.excepciones;

@SuppressWarnings("serial")
public class NoPuedeProveerAPaisDistintoException extends Exception {
	public NoPuedeProveerAPaisDistintoException(String msg) {
		super(msg);
	}
}
