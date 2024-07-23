package service;

import entity.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);

    Person update(Person person);

    Boolean find(Person person);

    List<Person> findAll();
    void delete(Person person);
}
