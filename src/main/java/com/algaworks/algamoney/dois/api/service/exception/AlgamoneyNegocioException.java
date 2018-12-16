package com.algaworks.algamoney.dois.api.service.exception;

public class AlgamoneyNegocioException extends RuntimeException {

	private static final long serialVersionUID = 4744067662094824647L;

	public AlgamoneyNegocioException() {
	}

	public AlgamoneyNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	public AlgamoneyNegocioException(String message) {
		super(message);
	}

	
}
