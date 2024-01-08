package ru.study.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.study.models.StudentsEntity;

import java.util.List;

@Stateless
public class StudentsRepository {
    @PersistenceContext
    private EntityManager em;

    public List<StudentsEntity> findAll() {
        return em.createQuery("select i from StudentsEntity i",
                StudentsEntity.class).getResultList();
    }

    public StudentsEntity findByIdCard(int id) {
        return em.createQuery("select i from StudentsEntity i where i.id = :id",
                        StudentsEntity.class).setParameter("id", id)
                .getSingleResult();
    }

    public List<StudentsEntity> findByIdDorm(int id) {
        return em.createQuery("select i from StudentsEntity i where i.id_dorm = :id",
                        StudentsEntity.class).setParameter("id", id)
                .getResultList();
    }

    public void persist(StudentsEntity entity) {
        em.persist(entity);
    }

    public void delete(int studentId) {
        StudentsEntity entity = em.find(StudentsEntity.class, studentId);
        em.remove(entity);
    }
}