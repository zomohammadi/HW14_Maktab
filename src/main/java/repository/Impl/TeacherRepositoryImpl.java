package repository.Impl;

import entity.Person;
import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import org.hibernate.PropertyValueException;
import repository.TeacherRepository;

import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {
    private EntityManager entityManager;

    public TeacherRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Teacher save(Teacher teacher) {
        Teacher savedTeacher = null;
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(teacher);
            entityManager.getTransaction().commit();
            savedTeacher = teacher;
        } catch (PropertyValueException e) {
            System.out.println("the first name and last name in DB are not be null");
        } catch (RollbackException e) {
            System.out.println("duplicate value: the first name and last name in DB are exists");
        }catch (IllegalArgumentException e){
            System.out.println("can not save null entity");
        }
        return savedTeacher;
    }
}
