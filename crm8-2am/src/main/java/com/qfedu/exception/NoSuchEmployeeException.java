package com.qfedu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "û��������Ա��")
public class NoSuchEmployeeException extends RuntimeException {

	public NoSuchEmployeeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoSuchEmployeeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchEmployeeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchEmployeeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
