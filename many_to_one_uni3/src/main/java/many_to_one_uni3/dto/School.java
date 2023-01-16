package many_to_one_uni3.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int scl_int;
	private String scl_name;
	private long fee;
	private String location;
	@Override
	public String toString() {
		return "School [scl_int=" + scl_int + ", scl_name=" + scl_name + ", fee=" + fee + ", location=" + location
				+ "]";
	}
	public int getScl_int() {
		return scl_int;
	}
	public void setScl_int(int scl_int) {
		this.scl_int = scl_int;
	}
	public String getScl_name() {
		return scl_name;
	}
	public void setScl_name(String scl_name) {
		this.scl_name = scl_name;
	}
	public long getFee() {
		return fee;
	}
	public void setFee(long fee) {
		this.fee = fee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
