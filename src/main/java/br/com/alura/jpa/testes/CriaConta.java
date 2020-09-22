package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");

		EntityManager em = emf.createEntityManager();
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setNumero(1234);
		conta.setAgencia(4321);
		conta.setSaldo(100.0);

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close(); // o primeiro (em) morreu aqui no close

		System.out.println("ID conta da Marcia : " + conta.getId());

		EntityManager em2 = emf.createEntityManager(); // criando outro (em2) para alterar o saldo da conta
		conta.setSaldo(500.0);

		em2.getTransaction().begin();
		em2.merge(conta); // transformou a conta Manager novamente
		em2.getTransaction().commit();

	}

}
