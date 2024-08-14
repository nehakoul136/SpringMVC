package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.nt.Employee;

@Component
public class EmployeeDao {
	
	@Autowired
	JdbcTemplate template;
	
	public int register(Employee e) {
		Object[] args = {e.getId(), e.getName(), e.getSalary()};
		String sql = "Insert into employee values(?,?,?)";
		int result = template.update(sql, args);
		return result;	
	}

	public int update(int id, int salary) {
		String sql = "Update Employee set salary = ? where id = ?";
		Object[] args = {salary, id};
		int result = template.update(sql,args);
		return result;
	}

	public int delete(int id) {
		String sql = "Delete from Employee where id = ?";
		Object[] args = {id};
		int result = template.update(sql,args);
		return result;
	}

	public Employee read(int id) {
		String sql = "Select * from Employee where id = ?";
		Object[] args = {id};
		Employee e = template.queryForObject(sql, new EmployeeRowMapper(), args);
		System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
		return e;
		
	}

	public List<Employee> readAll() {
		 List<Employee> e = new ArrayList<Employee>();
		 String sql = "Select * from Employee";
		 e = template.query(sql, new EmployeeRowMapper());
		
		return e;
	}

}
