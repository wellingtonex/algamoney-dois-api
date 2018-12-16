package com.algaworks.algamoney.dois.api.repository.lancamento;

import java.util.List;

import com.algaworks.algamoney.dois.api.model.Lancamento;
import com.algaworks.algamoney.dois.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> pesquisar(LancamentoFilter filter);
}
