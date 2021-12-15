package com.ashisoma.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    public User() {

    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
