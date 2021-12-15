package com.ashisoma.demo.controller;

import com.ashisoma.demo.entity.Department;
import com.ashisoma.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public Department saveDepartment(@RequestBody Department department){
        return service.saveDept(department);
    }

    @GetMapping(value = "/")
    public List<Department> getAllDept(){
        return service.getAllDepartments();
    }

    @GetMapping(value = "/{id}")
    public Department getDeptById(@PathVariable("id") Long id){
        return service.getDepartmentsById(id);
    }

    @GetMapping(value = "/name/{name}")
    public Department getDeptByName(@PathVariable("name") String departmentName){
        return service.getDepartmentsByNamedepartmentName(departmentName);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
         service.deleteById(id);
         return "Department with"+  id + "deleted successfully!!!";
    }

    @PutMapping(value = "/put/{id}")
    public Department updateDept(@PathVariable("id") Long id,
                                                                            @RequestBody Department department){
        return service.updateDepartment(id, department);
    }


}
