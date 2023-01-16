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


public class TeachersDao {
	public EntityManager getentityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void saveTeacher(Teachers teachers) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school = teachers.getSchool();
		entityTransaction.begin();
		entityManager.merge(school);
		entityManager.persist(teachers);
		entityTransaction.commit();
	}
	public void updateTeachers(int id, Teachers teachers) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Teachers teachers2 = entityManager.find(Teachers.class, id);
		if (teachers2 != null) {
			entityManager.merge(teachers);
		} else {
			System.out.println("teacher id doesnt exist");
		}
	}
	public void deleteTeachers(int id, Teachers teachers) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Teachers teachers2 = entityManager.find(Teachers.class, id);
		if (teachers2 != null) {
			entityManager.remove(teachers);
		} else {
			System.out.println("teacher id doesnt exist");
		}
	}
	public void displayById(int id,Teachers teachers) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Teachers teachers2 = entityManager.find(Teachers.class, id);
		if (teachers2 != null) {
			entityManager.find(Teachers.class, id);
		} else {
			System.out.println("Teacher id doesnt exist");
		}
	}

	public void disPlayAll() {
		EntityManager entityManager = getentityManager();
		Query q = entityManager.createQuery("select c from teachers c");
		List<Student> list = q.getResultList();
		System.out.println(list);
	}
}
