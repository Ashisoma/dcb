package com.ashisoma.demo.repos;

import com.ashisoma.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String departmentName);

//    List<Department> findByDepartmentNameContainsIgnoreCase(String departmentName);

    @Query("select d from Department d where upper(d.departmentName) like upper(concat('%', ?1, '%'))")
    List<Department> findByDepartmentNameContainsIgnoreCaseAllIgnoreCase(String departmentName);

    @Query("select d from Department d where upper(d.departmentName) = upper(?1)")
    List<Department> findByDepartmentNameIgnoreCaseAllIgnoreCase(String departmentName);
}