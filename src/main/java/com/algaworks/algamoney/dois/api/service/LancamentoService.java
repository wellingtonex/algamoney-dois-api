package com.algaworks.algamoney.dois.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algamoney.dois.api.model.Lancamento;
import com.algaworks.algamoney.dois.api.model.Pessoa;
import com.algaworks.algamoney.dois.api.repository.LancamentoRepository;
import com.algaworks.algamoney.dois.api.repository.PessoaRepository;
import com.algaworks.algamoney.dois.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		
		if(pessoa == null || !pessoa.EAtivo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		return repository.save(lancamento);
	}
}
