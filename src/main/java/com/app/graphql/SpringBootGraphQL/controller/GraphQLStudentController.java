package com.app.graphql.SpringBootGraphQL.controller;

import com.app.graphql.SpringBootGraphQL.entitites.Course;
import com.app.graphql.SpringBootGraphQL.entitites.Student;
import com.app.graphql.SpringBootGraphQL.graphql.InputStudent;
import com.app.graphql.SpringBootGraphQL.service.ICourseService;
import com.app.graphql.SpringBootGraphQL.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {
    @Autowired
    IStudentService studentService;
    @Autowired
    ICourseService courseService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument("studentId")String id){
    Long studentId= Long.parseLong(id);
    return studentService.findById(studentId);
    }

@QueryMapping(name = "findAllStudents")
    public List<Student> allStudents(){
      return  studentService.findAll();
    }

@MutationMapping(name = "createStudent")
    public Student crearEstudiante(@Argument InputStudent inputStudent){
        Course course =  courseService.findCourseById(Long.parseLong(inputStudent.getCourseId()));
        Student student = new Student();
        student.setName(inputStudent.getName());
        student.setLastName(inputStudent.getLastName());
        student.setAge(inputStudent.getAge());
        student.setCourse(course);
        studentService.createStudent(student);

        return student;
}
@MutationMapping(name = "deleteStudentById")
public String deleteById(@Argument (name = "studentId" ) String id){
        studentService.deleteById(Long.parseLong(id));
return "el estudiante con id " + id + " ha sido eliminado";
}
@MutationMapping(name = "findAllCourses")
public List<Course> findAll(){
        return courseService.findAll();
}

}
