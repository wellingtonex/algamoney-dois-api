package com.algaworks.algamoney.dois.api.repository.projetion;

public class ResumoPessoa {

	private Long codigo;
	private String nome;
	private String cidade;
	private String estado;
	private Boolean status;
	
	public ResumoPessoa(Long codigo, String nome, String cidade, String estado, Boolean status) {
		this.codigo = codigo;
		this.nome = nome;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
	}

	public ResumoPessoa(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long id) {
		this.codigo = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
