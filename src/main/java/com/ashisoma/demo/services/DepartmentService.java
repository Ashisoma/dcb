package com.ashisoma.demo.services;

import com.ashisoma.demo.entity.Department;
import com.ashisoma.demo.repos.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {

    @Autowired
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Department saveDept(Department department) {
        return  repository.save(department);
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    public Department getDepartmentsById(Long id) {
        return repository.findById(id).get();
    }

    public void deleteById(Long id) {
         repository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department department) {
        Department dep = repository.findById(id).get();
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            dep.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            dep.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            dep.setDepartmentAddress(department.getDepartmentAddress());
        }

        return repository.save(dep);
    }

    public Department getDepartmentsByNamedepartmentName(String departmentName) {
        return repository.findByDepartmentName(departmentName);
    }
}
