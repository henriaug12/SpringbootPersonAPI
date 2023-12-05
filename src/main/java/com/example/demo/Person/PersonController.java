package com.example.demo.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Optional<Person> getOnePerson(@PathVariable("id") Long id) {
      return personService.getOnePerson(id);
    }

    @PostMapping
    public ResponseEntity<String> postPerson(@RequestBody Person person){
      personService.addNewPerson(person);
      return ResponseEntity.status(HttpStatus.CREATED).body("CODE 201\n");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> putPerson(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) LocalDate dob,
        @RequestParam(required = false) String email){
      personService.updatePerson(id, name, dob, email);
      return ResponseEntity.status(HttpStatus.OK).body("CODE 200\n");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeletePerson(@PathVariable("id") Long id){
      personService.deletePerson(id);
      return ResponseEntity.status(HttpStatus.OK).body("CODE 200\n");
    }
    
}
