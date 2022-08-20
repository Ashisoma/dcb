package com.ashisoma.demo.services;

import com.ashisoma.demo.entity.Department;
import com.ashisoma.demo.error.DeptNotFoundException;
import com.ashisoma.demo.repos.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Department getDepartmentsById(Long id) throws DeptNotFoundException {
        Optional<Department> department =  repository.findById(id);
        if (!department.isPresent()){
            throw new DeptNotFoundException("Department Not Available");
        }
        return department.get();
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

    public List<Department> getDepartmentsByNamedepartmentName(String departmentName) {
        return repository.findByDepartmentNameContainsIgnoreCaseAllIgnoreCase(departmentName);
    }
}
