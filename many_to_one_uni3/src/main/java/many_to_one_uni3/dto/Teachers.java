package many_to_one_uni3.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Teachers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int t_id;
	private String t_name;
	private String t_subject;
	private long t_salary;
	@ManyToOne
	private School school;
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_subject() {
		return t_subject;
	}
	public void setT_subject(String t_subject) {
		this.t_subject = t_subject;
	}
	public long getT_salary() {
		return t_salary;
	}
	public void setT_salary(long t_salary) {
		this.t_salary = t_salary;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Teachers [t_id=" + t_id + ", t_name=" + t_name + ", t_subject=" + t_subject + ", t_salary=" + t_salary
				+ ", school=" + school + "]";
	}
}
