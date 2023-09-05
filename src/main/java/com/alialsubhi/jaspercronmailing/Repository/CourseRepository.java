package com.alialsubhi.jaspercronmailing.Repository;

import com.alialsubhi.jaspercronmailing.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
