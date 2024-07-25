package service.Impl;

import entity.Teacher;
import repository.PersonRepository;
import service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    PersonRepository<Teacher> personRepository;

    public TeacherServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return personRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return personRepository.update(teacher);
    }

    @Override
    public Teacher find(Teacher teacher) {
        return personRepository.find(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        personRepository.delete(teacher);
    }

    @Override
    public List<Teacher> findAll(String tableName) {
        return personRepository.findAll(tableName);
    }

    @Override
    public boolean contains(Long id) {
        return personRepository.contains(id);
    }

}
