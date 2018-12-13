package com.algaworks.algamoney.dois.api.repository;

import com.algaworks.algamoney.dois.api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}