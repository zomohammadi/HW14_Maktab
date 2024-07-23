package repository;

import entity.Person;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Set;

public interface PersonRepository {
    void save(Person person);

    Person update(Person person);

    Boolean find(Person person);

    List<Person> findAll();
    void delete(Person person);
}
