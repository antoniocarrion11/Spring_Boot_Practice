package com.example.miles.dao;

import com.example.miles.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class PersonFakePersonDataAccessService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID uuid) {
        return DB.stream()
                .filter(person -> person.getId().equals(uuid))
                .findFirst();
    }


    public int deletePersonById(UUID uuid) {
       Optional<Person> person = selectPersonById(uuid);
       if(person.isPresent()){
           DB.remove(person.get());
           return 1;
       }
        return 0;
    }


}
