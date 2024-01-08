package ru.study.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.study.models.RoomsEntity;

import java.util.List;

@Stateless
public class RoomsRepository {
    @PersistenceContext
    private EntityManager em;

    public List<RoomsEntity> findAll() {
        return em.createQuery("select i from RoomsEntity i ", RoomsEntity.class).getResultList();
    }

    public List<RoomsEntity> findByIdRoom(int id_dorm) {
        return em.createQuery("select i from RoomsEntity i where i.id_dorm = :id_dorm", RoomsEntity.class)
                .setParameter("id_dorm", id_dorm)
                .getResultList();
    }

    public void persist(RoomsEntity entity) {
        em.persist(entity);
    }

    public void delete(int id_dorm, int id_room) {
        em.createQuery("delete from StudentsEntity where id_room = :id_room").setParameter("id_room", id_room).executeUpdate();

        RoomsEntity entity = (RoomsEntity) em.createQuery("select i from RoomsEntity i where i.id_dorm = :value1 and i.id_room = :value2")
                .setParameter("value1", id_dorm)
                .setParameter("value2", id_room)
                .getSingleResult();
        em.remove(entity);
    }
}
