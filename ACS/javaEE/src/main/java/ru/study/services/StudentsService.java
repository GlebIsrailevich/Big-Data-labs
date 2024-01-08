package ru.study.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.study.models.StudentsEntity;
import ru.study.models.dto.StudentsRequest;
import ru.study.repositories.StudentsRepository;

import java.util.List;

@Stateless
public class StudentsService {
    @Inject
    private StudentsRepository studentsRepository;

    public List<StudentsEntity> getAll() {
        return studentsRepository.findAll();
    }

    public void create(StudentsRequest studentsRequest) {
        StudentsEntity student = new StudentsEntity(
                studentsRequest.getId_dorm(),
                studentsRequest.getId(),
                studentsRequest.getId_room(),
                studentsRequest.getName(),
                studentsRequest.getSex(),
                studentsRequest.getScore(),
                studentsRequest.getYearEducation()
        );
        studentsRepository.persist(student);
    }

    public void delete(int studentId) {
        studentsRepository.delete(studentId);
    }

}