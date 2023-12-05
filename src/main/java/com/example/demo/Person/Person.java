package com.example.demo.Person;

import java.time.LocalDate;
import java.time.Period;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Person {
    
    @Id
    @SequenceGenerator(
        name = "student_sequence", 
        sequenceName = "student_sequence", 
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, 
        generator = "student_sequence"
    )
    private Long id;

    private String name;

    private LocalDate dob;

    private String email;

    public Person(){}

    public Person (String name, LocalDate dob, String email){
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDob(LocalDate dob){
        this.dob = dob;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
