package com.algaworks.algamoney.dois.api.service.exception;

public class PessoaInexistenteOuInativaException extends AlgamoneyNegocioException {

	private static final long serialVersionUID = -3716694058450524639L;

	public PessoaInexistenteOuInativaException() {
		super("pessoa.inativa-ou-inexistente");
	}
}
