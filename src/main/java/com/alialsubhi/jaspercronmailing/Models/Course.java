package com.alialsubhi.jaspercronmailing.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Define a relationship to represent marks associated with the course
    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Mark> marks = new ArrayList<>();

}
