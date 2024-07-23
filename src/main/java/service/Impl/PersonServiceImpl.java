package service.Impl;

import entity.Person;
import repository.PersonRepository;
import service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
            return personRepository.update(person);
    }

    @Override
    public Boolean find(Person person) {
        /*try {*/
            return personRepository.find(person);
        /*} catch (IndexOutOfBoundsException e) {
            System.out.println("user not found in database");
        } catch (NullPointerException e) {
            System.out.println("can not pass Null value");
        }
        return null;*/
    }

        @Override
        public List<Person> findAll() {
            return personRepository.findAll();
        }

        @Override
        public void delete(Person person){
            personRepository.delete(person);
        }
}

