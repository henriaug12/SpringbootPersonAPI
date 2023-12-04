package com.example.demo.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/person")

public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getAllPersons() {
      return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getOnePerson(@RequestParam(value = "id") int id) {
      return null;
    }

    @PostMapping
    public ResponseEntity<String> postPerson(){
      return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
    }

    @PutMapping
    public ResponseEntity<String> putPerson(){

      return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be OK (CODE 200)\n");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeletePerson(){
      return ResponseEntity.status(HttpStatus.OK).body("HTTP Status will be OK (CODE 200)\n");
    }
    
}
