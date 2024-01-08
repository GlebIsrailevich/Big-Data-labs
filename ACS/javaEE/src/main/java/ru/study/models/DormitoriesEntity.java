package ru.study.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dormitories")
public class DormitoriesEntity {
    @Id
    @Column(name = "university")
    private String university;

    @Column(name = "id_dorm")
    private int id_dorm;
}
