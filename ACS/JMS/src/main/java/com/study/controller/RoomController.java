package com.study.controller;

import com.study.models.EventType;
import com.study.models.Model;
import com.study.models.Room;
import com.study.repos.RoomRepository;
import com.study.services.senders.JmsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    JmsSenderService jmsSenderService;

    @GetMapping("/room")
    public Iterable<Room> getRoom() {
        return roomRepository.findAll();
    }

    @PostMapping("/room")
    public @ResponseBody Room createRoom(@RequestBody Room room) {
        var room_ = roomRepository.save(room);
        jmsSenderService.sendEvent(room_, EventType.CREATE, Model.Room);
        return room;
    }

    @DeleteMapping("/room/{id}")
    public @ResponseBody void deleteRoom(@PathVariable int id) {
        var room = roomRepository.findById(id);
        if (room.isPresent()){
            jmsSenderService.sendEvent(room, EventType.DELETE, Model.Room);
            roomRepository.deleteById(id);
        }
    }

    @PutMapping("/room/{id}")
    public @ResponseBody Room updateRoom(@RequestBody Room newRoom, @PathVariable Integer id) {
        var room_ = roomRepository.findById(id)
                .map(room -> {
                    room.setId_room(newRoom.getId_room());
                    room.setId_dorm(newRoom.getId_dorm());
                    return roomRepository.save(room);
                })
                .orElseGet(() -> {
                    return roomRepository.save(newRoom);
                });

        jmsSenderService.sendEvent(room_, EventType.UPDATE, Model.Room);
        return room_;
    }
}