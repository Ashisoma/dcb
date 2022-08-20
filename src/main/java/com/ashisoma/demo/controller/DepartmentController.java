package com.ashisoma.demo.controller;

import com.ashisoma.demo.entity.Department;
import com.ashisoma.demo.error.DeptNotFoundException;
import com.ashisoma.demo.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/dpt")
public class DepartmentController {

    @Autowired
    private final DepartmentService service;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("IN THE SAVE DEPT FUNCTION");
        return service.saveDept(department);
    }

    @GetMapping
    public List<Department> getAllDept(){
        LOGGER.info("IN THE GET DEPT FUNCTION");
        return service.getAllDepartments();
    }

    @GetMapping(value = "/{id}")
    public Department getDeptById(@PathVariable("id") Long id) throws DeptNotFoundException {
        return service.getDepartmentsById(id);
    }

    @GetMapping(value = "/name/{departmentName}")
    public Department getDeptByName(@PathVariable("departmentName") String departmentName){
        return service.getDepartmentsByNamedepartmentName(departmentName);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
         service.deleteById(id);
         return "Department with"+  id + "deleted successfully!!!";
    }

    @PutMapping(value = "/put/{id}")
    public Department updateDept(@PathVariable("id") Long id, @Valid @RequestBody Department department){
        return service.updateDepartment(id, department);
    }


}
