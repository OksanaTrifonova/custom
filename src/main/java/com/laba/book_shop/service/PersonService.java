package com.laba.book_shop;

import com.laba.book_shop.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonService {
    private final Map<String, Person> persons;

    @Autowired
    public PersonService(Map<String, Person> persons) {
        this.persons = persons;
    }

    public Person getPerson(String beanId) {
        return persons.get(beanId);
    }
}