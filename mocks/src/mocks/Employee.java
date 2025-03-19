package mocks;

public record Employee(int id,String name,int salary) {

	public Employee() {
		this(0,"",0);
	}
	
}
