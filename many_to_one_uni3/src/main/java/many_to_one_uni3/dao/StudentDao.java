package many_to_one_uni3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_uni3.dto.School;
import many_to_one_uni3.dto.Student;


public class StudentDao {
	public EntityManager getentityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}

	public void saveStudent(Student student, int schoolId) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		School school = entityManager.find(School.class, schoolId);
		student.setSchool(school);
		entityManager.persist(student);
		entityTransaction.commit();
	}
	public void updateStudent(int id, Student student) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Student student2 = entityManager.find(Student.class, id);
		if (student2 != null) {
			entityManager.merge(student);
		} else {
			System.out.println("student id doesnt exist");
		}
		entityTransaction.commit();
	}
	public void deleteStudent(int id) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Student student2 = entityManager.find(Student.class, id);
		if (student2 != null) {
			entityManager.remove(student2);
		} else {
			System.out.println("Student id doesnt exist");
		}
		entityTransaction.commit();
	}
	public void displayById(int id) {
		EntityManager entityManager = getentityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Student student2 = entityManager.find(Student.class, id);
		if (student2 != null) {
			System.out.println(student2);
		} else {
			System.out.println("Student id doesnt exist");
		}
	}

	public void disPlayAll() {
		EntityManager entityManager = getentityManager();
		Query q = entityManager.createQuery("select c from student c");
		List<Student> list = q.getResultList();
		System.out.println(list);
	}
}
