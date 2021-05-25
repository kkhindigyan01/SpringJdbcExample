package com.kkhindigyan.org.dao;

import java.util.List;

import com.kkhindigyan.org.model.Employee;
/**
 * @author KK HindiGyan
 *This Employee DAO Interface
 */
public interface EmployeeDao {

	public abstract void createEmployee(Employee employee);
	public abstract Employee fetchEmployeeById(Integer employeeId);
	public abstract List<Employee> fetchAllEmployees();
	public abstract void updateEmployeeEmailById(String newEmail,Integer employeeId);
	public abstract void deleteEmployeeById(Integer employeeId);
}
