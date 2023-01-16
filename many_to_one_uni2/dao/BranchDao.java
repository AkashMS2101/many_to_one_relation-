package many_to_one_uni2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni2.dto.Bank;
import many_to_one_uni2.dto.Branch;

public class BranchDao {
	public EntityManager getentityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void saveBranch(List<Branch> list) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		for (Branch branch : list) {
			entityManager.persist(branch);
			Bank bank = branch.getBank();
			entityManager.persist(bank);
		}
		entityTransaction.commit();
	}
	public void updateBranch(int id, Branch branch) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Branch branch2 = entityManager.find(Branch.class, id);
		if (branch2 != null) {
			entityManager.merge(branch);
		} else {
			System.out.println("Branch id doesnt exist");
		}
	}

	public void deleteBranch(int id, Branch branch) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Branch branch2 = entityManager.find(Branch.class, id);
		if (branch2 != null) {
			entityManager.remove(branch);
		} else {
			System.out.println("Branch id doesnt exist");
		}
	}
	public void displayById(int id,Branch branch) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Branch branch2 = entityManager.find(Branch.class, id);
		if (branch2 != null) {
			entityManager.find(Branch.class, id);
		} else {
			System.out.println("Banch id doesnt exist");
		}
	}

	public void disPlayAll() {
		EntityManager entityManager = getentityManager();

		Query q = entityManager.createQuery("select c from branch c");
		List<Bank> list = q.getResultList();
		System.out.println(list);
	}
}
