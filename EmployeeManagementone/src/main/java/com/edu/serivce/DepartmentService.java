package com.edu.serivce;

import java.util.List;

import com.edu.dao.Department;

public interface DepartmentService {

public 	Department saveDepartment(Department department);

public List<Department> getAllDepartments();

public Department getDepartmentById(Integer departmentId);

}
