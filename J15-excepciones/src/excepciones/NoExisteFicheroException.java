package excepciones;

@SuppressWarnings("serial")
public class NoExisteFicheroException extends RuntimeException {

	public NoExisteFicheroException() {
		super();
	}

	public NoExisteFicheroException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoExisteFicheroException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExisteFicheroException(String message) {
		super(message);
	}

	public NoExisteFicheroException(Throwable cause) {
		super(cause);
	}
	
}
