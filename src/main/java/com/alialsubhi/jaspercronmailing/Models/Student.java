package com.alialsubhi.jaspercronmailing.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "email" /*,unique = true, nullable = false*/)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "started_date")
    private Date startedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "expected_graduate")
    private Date expectedGraduate;

    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;
}


/*  For Testing

INSERT INTO students (active, age, email, expected_graduate, first_name, last_name, started_date)
VALUES (1, 20, 'adaa@gmail.com', '2023-12-31', 'Ali', 'AlSubhi', '2023-01-04');

INSERT INTO students (active, age, email, expected_graduate, first_name, last_name, started_date)
VALUES (1, 22, 'bbfb@gmail.com', '2023-12-31', 'Nidhal', 'AlMamari', '2022-09-15');


*/