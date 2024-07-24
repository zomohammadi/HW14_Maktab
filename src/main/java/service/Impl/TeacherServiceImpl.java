package service.Impl;

import entity.Person;
import entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import org.hibernate.PropertyValueException;
import repository.TeacherRepository;
import service.TeacherService;
import util.ApplicationContext;

public class TeacherServiceImpl implements TeacherService {
    TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
