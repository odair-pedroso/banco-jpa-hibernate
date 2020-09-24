package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Movimentacao movimentacao = em.find(Movimentacao.class, 3L);
		Conta conta = movimentacao.getConta();

		int quantidadeDeMovimentacoes = conta.getMovimentacoes().size(); // metodo que ainda nao existe mas que é ma
																			// implementacao para sabermos quantas
		// movimentacoes temos em uma conta;

		System.out.println("Quantidade de movimentações : " + quantidadeDeMovimentacoes);
		System.out.println("O titular da conta desta movimentacao é : " + conta.getTitular());

	}

}
