package ru.study.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.study.models.RoomsEntity;
import ru.study.models.dto.RoomsRequest;
import ru.study.repositories.RoomsRepository;

import java.util.List;

@Stateless
public class RoomsService {
    @Inject
    private RoomsRepository roomsRepository;

    public List<RoomsEntity> getAll() {
        return roomsRepository.findAll();
    }

    public void create(RoomsRequest roomsRequest) {
        RoomsEntity room = new RoomsEntity(
                roomsRequest.getId_room(),
                roomsRequest.getId_dorm()
        );
        roomsRepository.persist(room);
    }

    public void delete(int id_dorm, int id_room) {
        roomsRepository.delete(id_dorm, id_room);
    }
}