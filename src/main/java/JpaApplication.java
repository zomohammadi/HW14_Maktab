import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import org.hibernate.PropertyValueException;
import repository.Impl.PersonRepositoryImpl;
import repository.PersonRepository;
import util.ApplicationContext;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

public class JpaApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = ApplicationContext.getInstance();

        //------save in DB

        Person person = Person.builder().firstName("Zohre").lastName("Saeedi").build();
        applicationContext.getPersonService().save(person);
        //-----RollbackException for duplicate value for unique constraint
        //-----PropertyValueException for not null constraint

        //-----update

        //-----user not found in DB
        Person person1 = Person.builder().firstName("ali").lastName("Mohammadi").build();
        updatePerson(applicationContext, person1);

        System.out.println("-------------");

        //-----user  found in DB
        //Person person = Person.builder().firstName("Zohre").lastName("Saeedi").build();
        updatePerson(applicationContext, person);
        System.out.println("-------------");
        updatePerson(applicationContext, null);

        System.out.println("---------------------------");
        //-----FindAll
        applicationContext.getPersonService().findAll().forEach(System.out::println);
        System.out.println("---------------------------");
        //-----delete
       // applicationContext.getPersonService().delete(person1);
        applicationContext.getPersonService().delete(null);
        //applicationContext.getPersonService().delete(person);

    }

    private static void updatePerson(ApplicationContext applicationContext, Person person) {
        if (person != null) {
            person.setBirthDate(LocalDate.of(1999, 3, 3));
            Person updatedPerson = applicationContext.getPersonService().update(person);
            if (updatedPerson != null)
                System.out.println("updated in DB. Done!");
        } else System.out.println("can not update null entity");
    }
}
