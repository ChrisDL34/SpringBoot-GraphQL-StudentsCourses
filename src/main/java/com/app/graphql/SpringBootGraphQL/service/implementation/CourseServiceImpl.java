package com.app.graphql.SpringBootGraphQL.service.implementation;


import com.app.graphql.SpringBootGraphQL.entitites.Course;
import com.app.graphql.SpringBootGraphQL.persistence.ICourseDAO;
import com.app.graphql.SpringBootGraphQL.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CourseServiceImpl implements ICourseService {
@Autowired
private ICourseDAO courseDAO;

    @Override
    @Transactional(readOnly = true)
    public Course findCourseById(Long id) {
        return courseDAO.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    @Transactional
    public void createCourse(Course course) {
courseDAO.save(course);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
courseDAO.deleteById(id);
    }
}
