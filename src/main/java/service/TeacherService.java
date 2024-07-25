package service;

import entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher);

    Teacher find(Teacher teacher);

    void delete(Teacher teacher);

    List<Teacher> findAll(String tableName);
    boolean contains(Long id);
}
