package com.algaworks.algamoney.dois.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.dois.api.model.Pessoa;
import com.algaworks.algamoney.dois.api.repository.PessoaRepository;
import com.algaworks.algamoney.dois.api.repository.projetion.ResumoPessoa;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscaPeloCodigo(codigo);
		
		pessoaSalva.getContatos().clear();
		pessoaSalva.getContatos().addAll(pessoa.getContatos());		
		pessoaSalva.getContatos().forEach(c -> c.setPessoa(pessoaSalva));
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo", "contatos");
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

	public List<ResumoPessoa> listarTodas() {	
		return pessoaRepository.listarTodas();
	}

	public Page<ResumoPessoa> resumir(String nome, Pageable pageable) {		
		return pessoaRepository.resumir(nome, pageable);
	}

	public Pessoa salvar(Pessoa pessoa) {
		pessoa.getContatos().forEach(c -> c.setPessoa(pessoa));
		return pessoaRepository.save(pessoa);
	}
}
