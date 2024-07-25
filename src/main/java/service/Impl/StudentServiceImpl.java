package service.Impl;

import entity.Student;
import repository.PersonRepository;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService/*<Student>*/ {
    PersonRepository<Student> personRepository;

    public StudentServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Student save(Student student) {
        return personRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return personRepository.update(student);
    }

    @Override
    public Student find(Student student) {
        return personRepository.find(student);
    }

    @Override
    public void delete(Student student) {
        personRepository.delete(student);
    }

    @Override
    public List<Student> findAll(String tableName) {
        return personRepository.findAll(tableName);
    }

    @Override
    public boolean contains(Long id) {
        return personRepository.contains(id);
    }
}
