package com.study.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.study.models.Dormitories;

import com.study.repos.StudentRepository;
import com.study.repos.RoomRepository;
import com.study.repos.DormitoryRepository;

import com.study.models.Student;
import com.study.models.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;


@Controller
<<<<<<< HEAD
@RequestMapping(
        value = "xsl",
        produces = {"application/xml"}
)
public class XslController {
=======
@RequestMapping("/xsl")
public class XslController {

>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    @Autowired
    private StudentRepository studentService;

    @Autowired
    private RoomRepository roomService;

    @Autowired
    private DormitoryRepository dormService;

    @ResponseBody
<<<<<<< HEAD
    @GetMapping(path = "/student")
=======
    @GetMapping(path = "/student", produces = MediaType.APPLICATION_XML_VALUE)
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    private ModelAndView getStudent() throws JsonProcessingException {
        Iterable<Student> list = studentService.findAll();
        return getModelAndView(list, "studentXSL");
    }

    @ResponseBody
<<<<<<< HEAD
    @GetMapping(path = "/room")
=======
    @GetMapping(path = "/room", produces = MediaType.APPLICATION_XML_VALUE)
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    public ModelAndView getRoom() throws JsonProcessingException {
        Iterable<Room> list = roomService.findAll();
        return getModelAndView(list, "roomXSL");
    }

    @ResponseBody
<<<<<<< HEAD
    @GetMapping(path = "/dorm")
=======
    @GetMapping(path = "/dorm", produces = MediaType.APPLICATION_XML_VALUE)
>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    public ModelAndView get() throws JsonProcessingException {
        Iterable<Dormitories> list = dormService.findAll();
        return getModelAndView(list, "dormXSL");
    }

<<<<<<< HEAD
=======

>>>>>>> 0acf1ed31b62ebe8e967442038f3c29222b46b25
    private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("List", src);
        return mod;
    }

}