package com.study.controller;

import com.study.models.Dormitories;
import com.study.repos.DormitoryRepository;
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
<<<<<<< HEAD
=======

>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
public class DormitoryController {
    @Autowired
    DormitoryRepository dormRepository;

    @GetMapping("/dorm")
    public Iterable<Dormitories> getDormitory() {
        return dormRepository.findAll();
    }

    @GetMapping("/dorm/{id}")
<<<<<<< HEAD
    public @ResponseBody Optional<Dormitories> getDormitory(@PathVariable int id) {
        return dormRepository.findById(id);
    }

    @PostMapping("/dorm")
    public @ResponseBody Dormitories createDormitory(@RequestBody Dormitories dormitory) {
        var dorm = dormRepository.save(dormitory);
        return dorm;
    }

    @DeleteMapping("/dorm/{id}")
    public @ResponseBody void deleteDormitory(@PathVariable int id) {
        var dorm = dormRepository.findById(id);
        if (dorm.isPresent()){
            dormRepository.deleteById(id);
        }
    }


    @PutMapping("/dorm/{id}")
    public @ResponseBody Dormitories updateDormitory(@RequestBody Dormitories newDorm, @PathVariable Integer id) {
        return dormRepository.findById(id)
                .map(dormitories -> {
                    dormitories.setId_dorm(newDorm.getId_dorm());
                    dormitories.setUniversity(newDorm.getUniversity());
                    return dormRepository.save(dormitories);
                })
                .orElseGet(() -> {
                    return dormRepository.save(newDorm);
                });
=======
    public @ResponseBody Optional<Dormitories> getDormitory(@PathVariable int id_card) {
        return dormRepository.findById(id_card);
    }
    @PostMapping("/student")
    public @ResponseBody Dormitories createDormitory(@RequestBody Dormitories dormitory) {
        return dormRepository.save(dormitory);
    }

    @DeleteMapping("/student/{id_card}")
    public @ResponseBody void deleteDormitory(@PathVariable int id_card) {
        dormRepository.deleteById(id_card);
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    }
}
