package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.Impl.PersonRepositoryImpl;
import repository.PersonRepository;
import service.Impl.PersonServiceImpl;
import service.PersonService;

public class ApplicationContext {

    private EntityManagerFactory enf;
    private EntityManager em;

    private final PersonRepository personRepository;
    private final PersonService personService;

    public ApplicationContext() {
        this.em = getEntityManager();
        personRepository = new PersonRepositoryImpl(em);
        personService = new PersonServiceImpl(personRepository);
    }

    private static ApplicationContext applicationContext;

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }


    public EntityManagerFactory getEntityManagerFactory() {
        if (enf == null) {
            enf = Persistence.createEntityManagerFactory("default");
        }
        return enf;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            em = getEntityManagerFactory().createEntityManager();
        }
        return em;
    }

    public PersonService getPersonService() {
        return personService;
    }
}
