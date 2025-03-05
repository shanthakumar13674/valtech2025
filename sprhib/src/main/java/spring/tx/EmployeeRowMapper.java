package spring.tx;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import spring.ioc.Employee;

@Component
public class EmployeeRowMapper implements RowMapper<Employee>	{
	@Override
	public Employee mapRow(ResultSet rs, int index) throws SQLException {
		return Employee.builder().id(rs.getInt(1)).name(rs.getString(2)).age(rs.getInt(3))
				.gender(rs.getString(4)).salary(rs.getFloat(5)).experience(rs.getInt(6))
				.level(rs.getInt(7)).build();
	}
}
