package spring.aop.revision;

import org.hibernate.Session;

import spring.ioc.Employee;

public interface EmployeeDAO {

	Employee save(Session ses, Employee e);

	Employee get(Session ses, int id);

	Employee update(Session ses, Employee e);

}