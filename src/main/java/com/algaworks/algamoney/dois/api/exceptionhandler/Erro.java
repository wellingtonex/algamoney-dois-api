package com.algaworks.algamoney.dois.api.exceptionhandler;

public class Erro {

	private String mensagem;
	private String descricao;

	public Erro(String mensagem, String descricao) {
		this.mensagem = mensagem;
		this.descricao = descricao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getDescricao() {
		return descricao;
	}

}