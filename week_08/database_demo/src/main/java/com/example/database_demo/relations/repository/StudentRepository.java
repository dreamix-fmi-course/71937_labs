package com.example.database_demo.relations.repository;

import com.example.database_demo.relations.model.Faculty;
import com.example.database_demo.relations.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentByFaculty(Faculty faculty); // it does it automatically :O
}
