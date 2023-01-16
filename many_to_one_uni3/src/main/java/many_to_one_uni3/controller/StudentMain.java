package many_to_one_uni3.controller;

import many_to_one_uni3.dao.SchoolDao;
import many_to_one_uni3.dao.StudentDao;
import many_to_one_uni3.dto.School;
import many_to_one_uni3.dto.Student;

public class StudentMain {
	public static void main(String[] args) {
		
		School  school = new School();
		school.setScl_name("KVH");
		school.setLocation("Hassan");
		school.setFee(40000);
		
		SchoolDao dao = new SchoolDao();
		//dao.saveSchool(school);
		
		Student student = new Student();
		student.setParent("Shankar");
		student.setPercentage(92);
		student.setS_name("suhas");
		student.setS_marks(668);
		
		Student student2 = new Student();
		student2.setParent("Sukanya");
		student2.setPercentage(87);
		student2.setS_marks(625);
		student2.setS_name("Yashu");
		
		StudentDao dao2 = new StudentDao();
		//dao2.saveStudent(student,1);
		//dao2.saveStudent(student2, 1);
		//student.setS_name("Suhas");
		//dao2.updateStudent(2, student);

		StudentDao dao3 = new StudentDao();
		student.setS_name("Suhas");
		dao3.updateStudent(1, student);
	}
}
