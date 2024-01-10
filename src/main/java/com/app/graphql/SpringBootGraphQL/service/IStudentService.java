package com.app.graphql.SpringBootGraphQL.service;

import com.app.graphql.SpringBootGraphQL.entitites.Student;

import java.util.List;

public interface IStudentService {

    Student findById(Long id);
    List<Student> findAll();

    void createStudent(Student student);

    void deleteById(Long id);


}
