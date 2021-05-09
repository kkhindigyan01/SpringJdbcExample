package com.kkhindigyan.org.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kkhindigyan.org.model.Employee;
import com.kkhindigyan.org.service.EmployeeService;
import com.kkhindigyan.org.service.EmployeeServiceImpl;
/**
 * @author Kishan Kumar
 *This is client program for Spring Application
 */
public class ClientTest {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = null;
		try {
			ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			EmployeeService employeeService = ctx.getBean(EmployeeServiceImpl.class);
			createEmployee(employeeService);
			//getEmployeeById(employeeService);
			//fetchAllEmployeesInfo(employeeService);
			//employeeService.updateEmployeeEmailById("kk.cs@gmail.com", 2);
			employeeService.deleteEmployeeById(2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ctx != null)
				ctx.close();
		}
	}

	private static void fetchAllEmployeesInfo(EmployeeService employeeService) {
		employeeService.getAllEmployees().forEach(System.out::println);
	}

	private static void getEmployeeById(EmployeeService employeeService) {
		Employee employee = employeeService.getEmployeeById(1);
		System.out.println(employee);
	}

	private static void createEmployee(EmployeeService employeeService) {
		Employee employee = getEmployee() ;
		employeeService.createEmployee(employee);
	}

	private static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setEmployeeName("KK");
		employee.setEmail("kk.m@gmail.com");
		employee.setGender("Male");
		employee.setSalary(95000.00);
		return employee;
	}

}
