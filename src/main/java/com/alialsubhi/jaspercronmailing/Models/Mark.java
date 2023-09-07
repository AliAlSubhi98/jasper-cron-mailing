package com.alialsubhi.jaspercronmailing.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "obtained_mark")
    private Double obtainedMark;

    @Column(name = "grade")
    private String grade;

    // Define relationships to link marks to students and courses
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public String getGrade() {
        if (obtainedMark >= 90) {
            return "A";
        } else if (obtainedMark >= 80) {
            return "B";
        } else if (obtainedMark >= 70) {
            return "C";
        } else if (obtainedMark >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
