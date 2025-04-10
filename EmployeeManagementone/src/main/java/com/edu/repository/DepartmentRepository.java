package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.dao.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer >{

}
