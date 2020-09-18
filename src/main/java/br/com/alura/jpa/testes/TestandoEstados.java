package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		// Conta em estado Transiente para a JPA , ela é uma conta normal mas tem
		// possibilidades de ser Manager no futuro
		Conta conta = new Conta();
		conta.setTitular("Odair");
		conta.setAgencia(1258888);
		conta.setNumero(123789);

		// Para transformar uma conta Transient e, Manager na JPA:
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		// Transient -> Managed
		em.persist(conta);

		// Managed -> Removed
		em.remove(conta);
		System.out.println("ID entidade Removida : " + conta.getId());

		em.getTransaction().commit();

	}

}
