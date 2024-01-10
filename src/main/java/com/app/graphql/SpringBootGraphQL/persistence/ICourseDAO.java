package com.app.graphql.SpringBootGraphQL.persistence;

import com.app.graphql.SpringBootGraphQL.entitites.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseDAO extends JpaRepository<Course,Long> {
}
