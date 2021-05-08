package com.kkhindigyan.org.service;

import java.util.List;

import com.kkhindigyan.org.dao.EmployeeDao;
import com.kkhindigyan.org.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void createEmployee(Employee employee) {
		getEmployeeDao().createEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		return getEmployeeDao().fetchEmployeeById(employeeId);
	}
	@Override
	public List<Employee> getAllEmployees() {
		return getEmployeeDao().fetchAllEmployees();
	}
	@Override
	public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
		getEmployeeDao().updateEmployeeEmailById(newEmail, employeeId);
	}
	@Override
	public void deleteEmployeeById(Integer employeeId) {
		getEmployeeDao().deleteEmployeeById(employeeId);
		
	}

}
