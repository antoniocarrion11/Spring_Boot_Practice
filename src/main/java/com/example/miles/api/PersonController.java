package com.example.miles.api;

import com.example.miles.model.Person;
import com.example.miles.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//In spring boot world controller is the resource, this is where our Restful http methods are made
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    //Dependency Injecting the service
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getPeople();
    }

}
