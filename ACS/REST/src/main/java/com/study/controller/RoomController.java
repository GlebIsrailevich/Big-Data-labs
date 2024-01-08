package com.study.controller;

import com.study.models.Room;
import com.study.repos.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/room")
    public Iterable<Room> getRoom() {
        return roomRepository.findAll();
    }

<<<<<<< HEAD
    @PostMapping("/room")
    public @ResponseBody Room createRoom(@RequestBody Room room) {
        var room_ = roomRepository.save(room);
        return room;
=======
    @GetMapping("/room/{id}")
    public @ResponseBody Optional<Room> getRoom(@PathVariable int id_card) {
        return roomRepository.findById(id_card);
    }

    @PostMapping("/room")
    public @ResponseBody Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    @DeleteMapping("/room/{id_card}")
    public @ResponseBody void deleteRoom(@PathVariable int id_card) {
        roomRepository.deleteById(id_card);
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    }

    @DeleteMapping("/room/{id}")
    public @ResponseBody void deleteRoom(@PathVariable int id) {
        var room = roomRepository.findById(id);
        if (room.isPresent()){
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
        return room_;
    }
}