package com.kkhindigyan.org.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kkhindigyan.org.mapper.EmployeeRowMapper;
import com.kkhindigyan.org.model.Employee;
/**
 * 
 * @author Kishan Kumar
 * This is DAO class
 */
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createEmployee(Employee employee) {
		String SQL = "INSERT INTO employee_table(employee_name ,email,gender,salary) VALUES (?,?,?,?)";
		int update = getJdbcTemplate().update(SQL, employee.getEmployeeName(),employee.getEmail(),employee.getGender(),employee.getSalary());
		if(update == 1) {
			System.out.println("Employee is created..");
		}
	}

	@Override
	public Employee fetchEmployeeById(Integer employeeId) {
		String SQL = "SELECT * FROM employee_table WHERE employee_id = ?";
		return getJdbcTemplate().queryForObject(SQL, new EmployeeRowMapper(), employeeId);
	}
	@Override
	public List<Employee> fetchAllEmployees() {
		String SQL = "SELECT * FROM employee_table";
		return getJdbcTemplate().query(SQL, new EmployeeRowMapper());
	}
	@Override
	public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
		String SQL = "UPDATE employee_table set email = ? WHERE employee_id = ?";
		int update = getJdbcTemplate().update(SQL, newEmail,employeeId);
		if(update == 1) {
			System.out.println("Employee email is updated for ID = "+employeeId);
		}
	}
	@Override
	public void deleteEmployeeById(Integer employeeId) {
		String SQL = "DELETE FROM employee_table WHERE employee_id = ?";
		int update = getJdbcTemplate().update(SQL,employeeId);
		if(update == 1) {
			System.out.println("Employee is deleted with ID = "+employeeId);
		}
	}
}
