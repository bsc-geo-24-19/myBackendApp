package com.example.demo.student;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Component
@Table(name="details")

public class Student {
    @Id

    @Column(name="ID")
    private Long ID;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="dob")
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long ID, String name, String email, LocalDate dob) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}




