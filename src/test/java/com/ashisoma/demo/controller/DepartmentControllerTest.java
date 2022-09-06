package com.ashisoma.demo.controller;

import com.ashisoma.demo.entity.Department;
import com.ashisoma.demo.error.DeptNotFoundException;
import com.ashisoma.demo.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService service;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Kisumu")
                .departmentName("HR")
                .departmentId(1L)
                .departmentCode("HR-5")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
      Department  inputDepartment = Department.builder()
                .departmentAddress("Kisumu")
                .departmentName("HR")
                .departmentId(1L)
                .departmentCode("HR-5")
                .build();
        Mockito.when(service.saveDept(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/api/v1/dpt/add")
                        .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"HR\",\n" +
                        "    \"departmentAddress\": \"Kisumu\",\n" +
                        "    \"departmentCode\": \"HR-5\"\n" +
                        "  }"))
                .andExpect(status().isOk());
    }

    @Test
    void getDeptById() throws Exception {
        Mockito.when(service.getDepartmentsById(1L)).thenReturn(department);

        mockMvc.perform(get("/api/v1/dpt/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }

//    @Test
//    void


}