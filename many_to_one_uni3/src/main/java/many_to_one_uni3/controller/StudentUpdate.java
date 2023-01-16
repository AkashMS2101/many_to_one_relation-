package many_to_one_uni3.controller;

import many_to_one_uni3.dao.StudentDao;
import many_to_one_uni3.dto.Student;

public class StudentUpdate {
	public static void main(String[] args) {
		Student student = new Student();
		student.setS_name("Akash");
		
		StudentDao dao = new StudentDao();
		dao.updateStudent(1, student);
	}
}
