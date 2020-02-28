package com.example.miles.model;

//This is our model object, this might be considered our dataObject
//We're going to use this to demo some SpringBoot dependency Injection too
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
