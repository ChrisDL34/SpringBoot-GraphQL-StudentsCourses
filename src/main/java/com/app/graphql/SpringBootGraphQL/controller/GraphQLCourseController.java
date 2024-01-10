package com.app.graphql.SpringBootGraphQL.controller;

import com.app.graphql.SpringBootGraphQL.entitites.Course;
import com.app.graphql.SpringBootGraphQL.graphql.InputCourse;
import com.app.graphql.SpringBootGraphQL.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCourseController {
    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id){
        Long courseId = Long.parseLong(id);

        return courseService.findCourseById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll(){
        return courseService.findAll();
    }



    @MutationMapping(name = "createCourse")
    public Course createCourse(@Argument InputCourse inputCourse){

        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());

        courseService.createCourse(course);
        return course;
    }

    @MutationMapping(name = "deleteCourseById")
    public String deleteById(@Argument(name = "courseId") String id){
        courseService.deleteById(Long.parseLong(id));
        return "El curso con id " + id + " ha sido eliminado";
    }


}
