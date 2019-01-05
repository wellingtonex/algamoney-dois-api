package com.algaworks.algamoney.dois.api.repository.pessoa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algamoney.dois.api.model.Pessoa;
import com.algaworks.algamoney.dois.api.model.Pessoa_;
import com.algaworks.algamoney.dois.api.repository.projetion.ResumoPessoa;

public class PessoaRepositoryImpl implements PessoaRepositoryQuery {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ResumoPessoa> listarTodas() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ResumoPessoa> criteria= builder.createQuery(ResumoPessoa.class);
		Root<Pessoa> root = criteria.from(Pessoa.class);
		
		criteria.select(builder.construct(ResumoPessoa.class
				, root.get(Pessoa_.codigo), root.get(Pessoa_.nome)));
		TypedQuery<ResumoPessoa> query = em.createQuery(criteria);		
		return query.getResultList();
		
	}

	@Override
	public Page<ResumoPessoa> resumir(String nome, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;

	}


}
