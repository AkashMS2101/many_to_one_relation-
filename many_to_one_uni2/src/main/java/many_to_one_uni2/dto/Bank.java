package many_to_one_uni2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String bank_name;
	private String ceo;
	private String head_office;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getHead_office() {
		return head_office;
	}
	public void setHead_office(String head_office) {
		this.head_office = head_office;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", bank_name=" + bank_name + ", ceo=" + ceo + ", head_office=" + head_office + "]";
	}
	
}
