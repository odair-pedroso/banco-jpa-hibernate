package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlteraSaldoContaLeonardo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaDoLeonardo = em.find(Conta.class, 1L);

		System.out.println("Conta do Leonardo -> " + contaDoLeonardo.getTitular()); // somente para testar se estamos
																					// alterando na conta de Leonardo
																					// mesmo

		em.getTransaction().begin();

		contaDoLeonardo.setSaldo(20.0);

		em.getTransaction().commit();

	}

}
