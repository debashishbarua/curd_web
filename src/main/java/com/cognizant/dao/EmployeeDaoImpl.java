package com.cognizant.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cognizant.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static List<Employee> list = new ArrayList<>(
			Arrays.asList(
					new Employee(101, " Mr. X", 5000.0), 
					new Employee(102, " Mr. S", 6000.0),
					new Employee(103, " Mr. A", 6000.0), 
					new Employee(104, " Mr. K", 7000.0),
					new Employee(105, " Mr. J", 8000.0), 
					new Employee(106, " Mr. Y", 9000.0),
					new Employee(107, " Mr. I", 4000.0)

			));

	public String create(Employee e) {
		if (list.add(e))
			return "SUCCESS";
		else
			return "FAIL";

	}

	public String update(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return list;
	}

	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
