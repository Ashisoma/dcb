package com.ashisoma.demo.services;

import com.ashisoma.demo.entity.Department;
import com.ashisoma.demo.repos.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentId(1L)
                .departmentCode("IT-06")
                .departmentAddress("Nairobi")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameAllIgnoreCase("IT"))
                .thenReturn(department);
    }



    @Test
    @DisplayName("GET DATA BASED ON VALID DEPARTMENT NAME")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department found =  departmentService.getDepartmentsByNamedepartmentName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());

    }
}