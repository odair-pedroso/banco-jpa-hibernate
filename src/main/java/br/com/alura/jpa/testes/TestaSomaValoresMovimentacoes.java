package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class TestaSomaValoresMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		MovimentacaoDao dao = new MovimentacaoDao(em);
		System.out.println("A soma dos valores das movimentacoes � : " + dao.getSomaDasMovimentacoes());

	}

}
