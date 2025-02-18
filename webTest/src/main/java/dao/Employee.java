package dao;

import java.util.Objects;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private Gender gender;
	private float salary;
	private int experience;
	private int level;
	
	public Employee() {}

	public Employee(int id, String name, int age, Gender gender, float salary, int experience, int level) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.experience = experience;
		this.level = level;
	}
	
	public static EmployeeBuilder builder()	{
		return new EmployeeBuilder(new Employee());
	}
	
	public static class EmployeeBuilder	{
		
		private Employee employee;
		
		public EmployeeBuilder(Employee employee) {
			this.employee = employee;
		}
		public EmployeeBuilder id(int id)	{
			employee.setId(id);
			return this;
		}
		public EmployeeBuilder name(String name)	{
			employee.setName(name);
			return this;
		}
		
		public EmployeeBuilder age(int age)	{
			employee.setAge(age);
			return this;
		}
		public EmployeeBuilder salary(float salary)	{
			employee.setSalary(salary);
			return this;
		}
		public EmployeeBuilder gender(String gender)	{
			employee.setGender(Gender.valueOf(gender.toUpperCase()));
			return this;
		}
		
		public EmployeeBuilder experience(int exp)	{
			employee.setExperience(exp);
			return this;
		}
		
		public EmployeeBuilder level(int level)	{
			employee.setLevel(level);
			return this;
		}
		
		public Employee build()	{
			return employee;
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary
				+ ", experience=" + experience + ", level=" + level + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, experience, gender, id, level, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && experience == other.experience && gender == other.gender && id == other.id
				&& level == other.level && Objects.equals(name, other.name)
				&& Float.floatToIntBits(salary) == Float.floatToIntBits(other.salary);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
