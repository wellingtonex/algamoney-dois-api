package com.algaworks.algamoney.dois.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoney.dois.api.model.Lancamento;
import com.algaworks.algamoney.dois.api.repository.filter.LancamentoFilter;
import com.algaworks.algamoney.dois.api.repository.projetion.ResumoLancamento;

public interface LancamentoRepositoryQuery {

	public Page<Lancamento> pesquisar(LancamentoFilter filter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter filter, Pageable pageable);
}
