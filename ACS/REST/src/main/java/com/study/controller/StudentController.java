package com.study.controller;

import com.study.models.Student;

import com.study.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/student")
    public @ResponseBody Iterable<Student> getStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id_card}")
    public @ResponseBody Optional<Student> getStudent(@PathVariable int id_card) {
        return studentRepository.findById(id_card);
    }

    @PostMapping("/student")
    public @ResponseBody Student createStudent(@RequestBody Student student) {
        var student_ = studentRepository.save(student);
        return student_;
    }

    @DeleteMapping("/student/{id_card}")
    public @ResponseBody void deleteStudent(@PathVariable int id_card) {
        var student = studentRepository.findById(id_card);
        if (student.isPresent()){
            studentRepository.deleteById(id_card);
        }
    }

    @PutMapping("/student/{id}")
    public @ResponseBody Student updateStudent(@RequestBody Student newStudent, @PathVariable Integer id) {
        return studentRepository.findById(id)
                .map(student -> {
                    if (newStudent.getAvg_score() != 0) {
                        student.setAvg_score(newStudent.getAvg_score());
                    }
                    if (newStudent.getId_dorm() != 0) {
                        student.setId_dorm(newStudent.getId_dorm());
                    }
                    if (newStudent.getYearEducation() != 0) {
                        student.setYearEducation(newStudent.getYearEducation());
                    }
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    return studentRepository.save(newStudent);
                });
    }
}

