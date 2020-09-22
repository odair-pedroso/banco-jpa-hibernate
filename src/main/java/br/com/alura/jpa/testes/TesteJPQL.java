package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

		// String query = "select * from movimentacao where conta_id = 2"; // select sql
		// de exemplo para descobrir todas as
		// movimentacoes da conta id=2; jdbc

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String sql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc"; // em JPQL usamos o
																									// nome da classe
		// (Movimentacao) e atribuimos uma
		// variavel
		// m ao valor

		Conta conta = new Conta();
		conta.setId(2L);
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pConta", conta);

		List<Movimentacao> movimentacoes = query.getResultList();
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Descrição : " + movimentacao.getDescricao());
			System.out.println("Valor : " + movimentacao.getValor());
			System.out.println("Tipo : " + movimentacao.getTipoMovimentacao());
		}

	}

}
