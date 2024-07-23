package repository.Impl;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;
import org.hibernate.PropertyValueException;
import repository.PersonRepository;

import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {
    private EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Person person) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();
        } catch (RollbackException e) {
            System.out.println("duplicate value: the first name and last name in DB are exists");
        } catch (PropertyValueException e) {
            System.out.println("the first name and last name in DB are not be null");
        }
        //-----RollbackException for duplicate value for unique constraint
        //-----PropertyValueException for not null constraint
    }

    @Override
    public Person update(Person person) {
        Person updatedPerson = null;
        if (find(person)) {
            entityManager.getTransaction().begin();
            updatedPerson = entityManager.merge(person);
            entityManager.getTransaction().commit();
        }
        return updatedPerson;
    }

    public Boolean find(Person person) {
        Long id;
        if (person != null) {
            TypedQuery<Person> typedQuery = entityManager.createQuery("""
                    select p from Person p where p.firstName = ?1 
                    and p.lastName = ?2 """, Person.class);
            try {

                typedQuery.setParameter(1, person.getFirstName());
                typedQuery.setParameter(2, person.getLastName());
                id = typedQuery.getResultList().get(0).getId();
                person.setId(id);
                return true;

            } catch (IndexOutOfBoundsException e) {
                System.out.println("user not found in database");
            }
        } else System.out.println("can not find null entity");
        return false;
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> typedQuery = entityManager.createQuery("select p from Person p", Person.class);
        List<Person> persons = typedQuery.getResultList();
        return persons;
    }

    @Override
    public void delete(Person person) {
        if (find(person)) {
            entityManager.getTransaction().begin();
            entityManager.remove(person);
            entityManager.getTransaction().commit();
        }

    }
}