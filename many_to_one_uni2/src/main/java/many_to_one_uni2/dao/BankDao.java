package many_to_one_uni2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import many_to_one_uni2.dto.Bank;

public class BankDao {
	public EntityManager getentityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void saveBank(Bank bank) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bank);
		entityTransaction.commit();
	}

	public void updateBank(int id, Bank bank) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Bank bank2 = entityManager.find(Bank.class, id);
		if (bank2 != null) {
			entityManager.merge(bank);
		} else {
			System.out.println("Bank id doesnt exist");
		}
	}

	public void deleteBank(int id, Bank bank) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Bank bank2 = entityManager.find(Bank.class, id);
		if (bank2 != null) {
			entityManager.remove(bank);
		} else {
			System.out.println("Bank id doesnt exist");
		}
	}

	public void displayById(int id,Bank bank) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Bank bank2 = entityManager.find(Bank.class, id);
		if (bank2 != null) {
			entityManager.find(Bank.class, id);
		} else {
			System.out.println("Bank id doesnt exist");
		}
	}

	public void disPlayAll() {
		EntityManager entityManager = getentityManager();

		Query q = entityManager.createQuery("select c from bank c");
		List<Bank> list = q.getResultList();
		System.out.println(list);
	}

}
