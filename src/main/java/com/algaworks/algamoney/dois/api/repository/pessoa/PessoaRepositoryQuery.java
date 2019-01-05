package com.algaworks.algamoney.dois.api.repository.pessoa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoney.dois.api.repository.projetion.ResumoPessoa;

public interface PessoaRepositoryQuery {

	public List<ResumoPessoa> listarTodas();
	public Page<ResumoPessoa> resumir(String nome, Pageable pageable);
}
