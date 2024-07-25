package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.Impl.PersonRepositoryImpl;
import repository.PersonRepository;
import service.Impl.StudentServiceImpl;
import service.Impl.TeacherServiceImpl;
import service.StudentService;
import service.TeacherService;

public class ApplicationContext {

    private EntityManagerFactory enf;
    private EntityManager em;

    private final PersonRepository personRepository;
    //private final PersonService personService;
    private final TeacherService teacherService;
    public  final StudentService studentService;

    public ApplicationContext() {
        this.em = getEntityManager();
        personRepository = new PersonRepositoryImpl(em);

        teacherService = new TeacherServiceImpl(personRepository);
        studentService = new StudentServiceImpl(personRepository);

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

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public StudentService getStudentService() {
        return studentService;
    }
}
