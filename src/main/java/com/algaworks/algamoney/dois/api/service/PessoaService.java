package com.algaworks.algamoney.dois.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.dois.api.model.Pessoa;
import com.algaworks.algamoney.dois.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return pessoaRepository.save(pessoaSalva);
	}

	public Pessoa alterarStatus(Long codigo, Boolean ativo) {
		Pessoa pessoa = buscaPeloCodigo(codigo);
		pessoa.setAtivo(ativo);
		return pessoaRepository.save(pessoa);
	}

	public Pessoa buscaPeloCodigo(Long codigo) {
		Pessoa pessoa = pessoaRepository.findOne(codigo);
		if (pessoa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa;
	}
}
