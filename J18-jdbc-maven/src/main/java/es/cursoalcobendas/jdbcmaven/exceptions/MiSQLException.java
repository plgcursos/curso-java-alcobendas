package es.cursoalcobendas.jdbcmaven.exceptions;

public class MiSQLException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MiSQLException() {
	}

	public MiSQLException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MiSQLException(String message, Throwable cause) {
		super(message, cause);
	}

	public MiSQLException(String message) {
		super(message);
	}

	public MiSQLException(Throwable cause) {
		super(cause);
	}

}
