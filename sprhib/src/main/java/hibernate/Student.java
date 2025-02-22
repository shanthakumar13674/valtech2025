package hibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Student {
	
	@EmbeddedId
	private StudentId id;
	private String name;
	private String fatherName;
	private String stream;
	@Embedded()
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="home_street")),
		@AttributeOverride(name="city",column=@Column(name="home_city")),
		@AttributeOverride(name="pinCode",column=@Column(name="home_pincode"))
	})
	private StudentAddress homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="current_street")),
		@AttributeOverride(name="city",column=@Column(name="current_city")),
		@AttributeOverride(name="pinCode",column=@Column(name="current_pincode"))
	})
	private StudentAddress currentAddress;
	public Student() {}
	public Student(StudentId id, String name, String fatherName, String stream, long mobile) {
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.stream = stream;
		this.mobile = mobile;
	}
	
	public Student(StudentId id, String name, String fatherName, String stream, long mobile, StudentAddress homeAddress,
			StudentAddress currentAddress) {
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.stream = stream;
		this.mobile = mobile;
		this.homeAddress = homeAddress;
		this.currentAddress = currentAddress;
	}
	public StudentAddress getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(StudentAddress homeAddress) {
		this.homeAddress = homeAddress;
	}
	public StudentAddress getCurrentAddress() {
		return currentAddress;
	}
	public void setCurrentAddress(StudentAddress currentAddress) {
		this.currentAddress = currentAddress;
	}
	public StudentId getId() {
		return id;
	}
	public void setId(StudentId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	private long mobile;

}
