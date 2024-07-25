package repository;

import entity.Person;
import jakarta.persistence.EntityManager;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Set;

public interface PersonRepository<T extends Person> {
    T save(T person);

    T update(T person);

    T find(T person);

    List<T> findAll(String tableName);
    void delete(T person);
    boolean contains(Long id);
}
