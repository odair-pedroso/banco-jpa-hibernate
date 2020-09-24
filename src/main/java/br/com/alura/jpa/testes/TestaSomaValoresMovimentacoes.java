package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaValoresMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "select sum(m.valor) from Movimentacao m";
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();

		String jpqlMedia = "select avg(m.valor) from Movimentacao m";
		TypedQuery<Double> query2 = em.createQuery(jpqlMedia, Double.class);
		Double mediaDasMovimentacoes = query2.getSingleResult();

		System.out.println("A soma dos valores das movimentacoes � : " + somaDasMovimentacoes);
		System.out.println("A m�dia dos valores das movimentacoes � : " + mediaDasMovimentacoes);

	}

}
