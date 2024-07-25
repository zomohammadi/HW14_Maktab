package repository.Impl;

import entity.Person;
import entity.Teacher;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.PropertyValueException;
import repository.PersonRepository;

import java.util.List;
import java.util.Objects;

public class PersonRepositoryImpl<T extends Person> implements PersonRepository<T> {
    private EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T save(T person) {
        T savedPerson = null;
        if (person != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(person);
                entityManager.getTransaction().commit();
                savedPerson = person;
            } catch (PropertyValueException e) {
                System.out.println("the first name and last name in DB are not be null");
            } catch (RollbackException e) {
                System.out.println("duplicate value: the first name and last name in DB are exists");
            } catch (IllegalArgumentException e) {
                System.out.println("can not save null entity");
            }
        } else {
            System.out.println("can not save null entity");
            return savedPerson;}
        //-----RollbackException for duplicate value for unique constraint
        //-----PropertyValueException for not null constraint
        return savedPerson;
    }

    @Override
    public T update(T person) {
        T updatedPerson = null;
        // if (find(person).getId()!=null) {
        entityManager.getTransaction().begin();
        updatedPerson = entityManager.merge(person);
        entityManager.getTransaction().commit();
        //  }
        return updatedPerson;
    }

    public T find(T person) {
        if (person != null) {
            try {
                TypedQuery typedQuery = entityManager.createQuery(" select p from "+person.getClass().getSimpleName().toLowerCase() +" p where p.firstName = ?1 and p.lastName = ?2 ", person.getClass());

                // Query typedQuery = entityManager.createQuery(" select p from " + person.getClass().getName().substring(7) + " p where p.firstName = ?1 and p.lastName = ?2 ");
                //Query typedQuery = entityManager.createQuery(" select p from Person p where p.firstName = ?1 and p.lastName = ?2 ",T);

                typedQuery.setParameter(1, person.getFirstName());
                typedQuery.setParameter(2, person.getLastName());
                T result = (T) typedQuery.getSingleResult();
                person.setId(result.getId());
                person.setFirstName(result.getFirstName());
                person.setLastName(result.getLastName());
                person.setBirthDate(result.getBirthDate());

                return person;

            } catch (IndexOutOfBoundsException | NoResultException e) {
                System.out.println("user not found in database");
            }
        } else System.out.println("can not find null entity");
        return null;
    }

    @Override
    public List<T> findAll(String tableName) {
        try {
//        Query query = entityManager.createQuery("FROM %s".formatted(T.TABLE_NAME));
            Query query = entityManager.createQuery("FROM ".concat(tableName.toLowerCase()));
            List<T> persons = query.getResultList();
            return persons;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delete(T person) {
        T t = find(person);
        if (t != null) {
            entityManager.getTransaction().begin();
            T merge = entityManager.merge(t);//change state to merged
            entityManager.remove(merge);
            entityManager.getTransaction().commit();
        }
        ;

    }

    @Override
    public boolean contains(Long id) {
        return entityManager.createQuery("select p from Person p where p.id = ?1 ", Person.class).setParameter(1,id).getResultList().size() != 0;
    }
}