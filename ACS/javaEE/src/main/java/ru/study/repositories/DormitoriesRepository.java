package ru.study.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.study.models.DormitoriesEntity;
import ru.study.models.StudentsEntity;

import java.util.List;

@Stateless
public class DormitoriesRepository {
    @PersistenceContext
    private EntityManager em;

    public List<DormitoriesEntity> findAll() {
        return em.createQuery("select i from DormitoriesEntity i",
                DormitoriesEntity.class).getResultList();
    }

    public StudentsEntity findByUniversity(String university) {
        return em.createQuery("select i from DormitoriesEntity i where i.university = :university",
                        StudentsEntity.class).setParameter("university", university)
                .getSingleResult();
    }

    public void persist(DormitoriesEntity entity) {
        em.persist(entity);
    }

    public void delete(String university, int id_dorm) {
        em.createQuery("delete from StudentsEntity where id_dorm = :id_dorm")
                .setParameter("id_room", id_dorm)
                .executeUpdate();

        em.createQuery("delete from RoomsEntity where id_dorm = :id_dorm")
                .setParameter("id_room", id_dorm)
                .executeUpdate();

        em.createQuery("delete from DormitoriesEntity where university = :university")
                .setParameter("university", university)
                .executeUpdate();
    }
}
