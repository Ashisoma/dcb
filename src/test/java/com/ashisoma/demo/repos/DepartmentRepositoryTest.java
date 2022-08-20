package com.ashisoma.demo.repos;

import com.ashisoma.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {
        Department department =  Department.builder()
                .departmentName("MECH-ENG")
                .departmentCode("M-07")
                .departmentAddress("Nakuru")
                .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_ThenReturnDepartment(){
        Department department = repository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "MECH-ENG");
    }


}