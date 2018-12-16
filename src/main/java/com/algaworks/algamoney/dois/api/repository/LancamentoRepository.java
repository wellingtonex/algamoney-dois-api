package com.algaworks.algamoney.dois.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algamoney.dois.api.model.Lancamento;
import com.algaworks.algamoney.dois.api.repository.lancamento.LancamentoRepositoryQuery;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
