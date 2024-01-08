package ru.study.models.dto;

import lombok.Data;

@Data
public class StudentsRequest {
    private int id_dorm;
    private int id;
    private int id_room;
    private String name;
    private String sex;
    private float score;
    private int yearEducation;
}