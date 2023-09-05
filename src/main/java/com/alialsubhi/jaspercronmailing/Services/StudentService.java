package com.alialsubhi.jaspercronmailing.Services;

import com.alialsubhi.jaspercronmailing.Models.Student;
import com.alialsubhi.jaspercronmailing.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student xStudents = studentRepository.findById(id).orElse(null);
        if (xStudents == null) {
            return null;
        }
        if (studentRepository.existsById(id)) {
            xStudents.setId(id); // Ensure the ID matches the path variable
            xStudents.setFirstName(updatedStudent.getFirstName());
            xStudents.setLastName(updatedStudent.getLastName());
            xStudents.setRollNumber(updatedStudent.getRollNumber());
            xStudents.setAge(updatedStudent.getAge());
            xStudents.setEmail(updatedStudent.getEmail());
            xStudents.setSchool(updatedStudent.getSchool());

            return studentRepository.save(xStudents);
        }
        return null; // Student with the given ID not found
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false; // Student with the given ID not found
    }
}
