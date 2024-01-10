package com.app.graphql.SpringBootGraphQL.service;

import com.app.graphql.SpringBootGraphQL.entitites.Course;

import java.util.List;

public interface ICourseService {

    Course findCourseById(Long id);

    List<Course> findAll();

    void createCourse(Course course);

    void deleteById(Long id);

}
