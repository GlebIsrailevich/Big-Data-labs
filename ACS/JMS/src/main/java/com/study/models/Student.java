package com.study.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "students")
public class Student implements Serializable {
    @Id
    @Column(name = "id_card")
    private int id_card;

    @Column(name = "id_dorm")
    private int id_dorm;

    @Column(name = "id_room")
    private int id_room;

    @Column(name = "full_name", unique = true)
    private String full_name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "avg_score")
    private float avg_score;

    @Column(name = "year_education")
    private int yearEducation;
}

