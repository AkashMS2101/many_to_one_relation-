package many_to_one_uni3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni3.dto.School;
import many_to_one_uni3.dto.Student;
import many_to_one_uni3.dto.Teachers;

public class SchoolDao {
	public EntityManager getentityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void saveSchool(School school) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(school);
		entityTransaction.commit();
	}

	public void updateSchool(int id, School school) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		School school2 = entityManager.find(School.class, id);
		if (school2 != null) {
			entityManager.merge(school);
		} else {
			System.out.println("school id doesnt exist");
		}
	}

	public void deleteSchool(int id, School school) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		School school2 = entityManager.find(School.class, id);
		if (school2 != null) {
			entityManager.remove(school);
		} else {
			System.out.println("School id doesnt exist");
		}
	}

	public void displayById(int id) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		School school2 = entityManager.find(School.class, id);
		if (school2 != null) {
			entityManager.find(School.class, id);
		} else {
			System.out.println("School id doesnt exist");
		}
	}

	public void disPlayAll() {
		EntityManager entityManager = getentityManager();
		Query q = entityManager.createQuery("select c from school c");
		List<Student> list = q.getResultList();
		System.out.println(list);
	}
}
