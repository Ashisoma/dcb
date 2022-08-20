package com.ashisoma.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Department {


    // other annotations for VALIDATOR
    /*
    @LENGHT
    @SIZE
    @EMAIL
    @POSITIVE
    @NEGATIVE
    @NEGATIVEorPositive
    @Future
    @Past
    @FutureorPresent
    @PastOrPRESENT

     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Department Name should not be empty")
    private String departmentName;
    @NotBlank(message = "Department address should not be empty")
    private String departmentAddress;

    @NotBlank(message = "Department Code should not be empty")
    private String departmentCode;


}
