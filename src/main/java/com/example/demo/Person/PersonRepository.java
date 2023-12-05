package com.example.demo.Person;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long>{
    @Query("SELECT p FROM Person p WHERE p.email =?1")
    Optional<Person> findPersonByEmail(String email);
}
