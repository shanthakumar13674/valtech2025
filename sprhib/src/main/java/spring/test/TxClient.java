package spring.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.ioc.Employee;
import spring.ioc.Gender;
import spring.tx.EmployeeService;

public class TxClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("tx-hib-ann.xml");
		Arrays.asList(ctx.getBeanDefinitionNames()).forEach(s -> System.out.println(s));
		EmployeeService es = ctx.getBean(EmployeeService.class);
		System.out.println(es.getClass().getName());
		es.update(new Employee(10,"Ten",10,Gender.FEMALE,100000,10,10));
		es.getAll().forEach(e -> System.out.println(e));
		ctx.close();
	}

}
