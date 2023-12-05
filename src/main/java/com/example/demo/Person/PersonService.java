package com.example.demo.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public Optional<Person> getOnePerson(Long id){
        Optional<Person> foundPerson = personRepository.findById(id);
        if(foundPerson.isPresent()){
            return foundPerson;
        }
        else return null;
    }

    
    public void addNewPerson(Person person){
        Optional<Person> personByEmail =  personRepository.findPersonByEmail(person.getEmail());
        if(personByEmail.isPresent()){
            throw new IllegalStateException("Email already taken");
        }
        personRepository.save(person);
    }

    public void updatePerson(Long id, String name, LocalDate dob, String email){
        Person personToUpdate = personRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Person with id " + id + " doesn't exist"));
        if(name != null &&
            name.length() > 0){
                personToUpdate.setName(name);
        }
        
        if(email != null &&
            email.length() > 0){
                Optional<Person> personOptional = personRepository.findPersonByEmail(email);
                if(personOptional.isPresent()){
                    throw new IllegalStateException("Email taken");
                }
                personToUpdate.setEmail(email);
        }

        if(dob != null){
                personToUpdate.setDob(dob);
        }

        personRepository.save(personToUpdate);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
