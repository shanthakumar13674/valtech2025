package spring.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import spring.ioc.Employee;

//@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(Employee e) {
		employeeDAO.save(e);
//		throw new RuntimeException("Checking Rollback");
//		TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Employee e) {
		employeeDAO.update(e);
//		TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(int id) {
		employeeDAO.delete(id);
	}

	@Override
	public Employee get(int id) {
		return employeeDAO.get(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
