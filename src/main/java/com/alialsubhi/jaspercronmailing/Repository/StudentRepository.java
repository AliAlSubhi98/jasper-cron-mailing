package com.alialsubhi.jaspercronmailing.Repository;

import com.alialsubhi.jaspercronmailing.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
