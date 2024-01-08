package ru.study.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.study.models.DormitoriesEntity;
import ru.study.models.dto.DormitoriesRequest;
import ru.study.repositories.DormitoriesRepository;

import java.util.List;

@Stateless
public class DormitoriesService {
    @Inject
    private DormitoriesRepository dormitoriesRepository;

    public List<DormitoriesEntity> getAll() {
        return dormitoriesRepository.findAll();
    }

    public void create(DormitoriesRequest dorm) {
        DormitoriesEntity d = new DormitoriesEntity(
                dorm.getUniversity(),
                dorm.getId_dorm()
        );
        dormitoriesRepository.persist(d);
    }

    public void delete(String university, int id_dorm) {
        dormitoriesRepository.delete(university, id_dorm);
    }
}
