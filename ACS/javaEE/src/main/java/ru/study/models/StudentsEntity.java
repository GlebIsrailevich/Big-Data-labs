package ru.study.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class StudentsEntity {
    @Column(name = "id_dorm")
    private int id_dorm;

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private int id;

    @Column(name = "id_room")
    private int id_room;


    @Column(name = "full_name", unique = true)
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "avg_score")
    private float score;

    @Column(name = "year_education")
    private int yearEducation;
}

