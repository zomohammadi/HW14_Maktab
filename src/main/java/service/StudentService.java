package service;

import entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student update(Student student);

    Student find(Student student);

    void delete(Student student);

    List<Student> findAll(String tableName);

    boolean contains(Long id);
}
