package com.study.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "dormitories")
public class Dormitories {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "university")
    private String university;

    @Column(name = "id_dorm")
    private int id_dorm;
}
