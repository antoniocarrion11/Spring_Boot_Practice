package com.example.miles.service;

import com.example.miles.dao.PersonDao;
import com.example.miles.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getPeople(){
        return personDao.selectAllPeople();
    }

    public int deletePerson(UUID uuid) {
        return personDao.deletePersonById(uuid);
    }

    public Optional<Person> getPersonById(UUID uuid) {
        return personDao.selectPersonById(uuid);
    }
}
