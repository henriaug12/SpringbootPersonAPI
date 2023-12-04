package com.example.demo.Person;

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

    private Integer age;

    private String sex;

    public Person(){}

    public Person (String name, Integer age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public String getSex(){
        return sex;
    }
}
