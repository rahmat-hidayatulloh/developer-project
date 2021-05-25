package id.latihan.exception;

import log.Log;

public class ApplicationException extends Exception {

	public int errorCode;

	public ApplicationException(String message, int errorCode) {
		super(message);
		Log.log(new Object[] { message, errorCode });
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
