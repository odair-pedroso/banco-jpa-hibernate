package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaValoresMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = cb.createQuery(BigDecimal.class);
		// select * from movimentacao;
		Root<Movimentacao> root = query.from(Movimentacao.class);

		// sum(m.valor);
		Expression<BigDecimal> sum = cb.sum(root.<BigDecimal>get("valor"));
		query.select(sum);

		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);

		System.out.println("A soma dos valores das movimentacoes é : " + typedQuery.getSingleResult());

	}

}
