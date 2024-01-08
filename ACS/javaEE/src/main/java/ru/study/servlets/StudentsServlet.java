package ru.study.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.models.dto.StudentsRequest;
import ru.study.services.StudentsService;
import ru.study.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "studentsServlet", value = "/students")
public class StudentsServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();
    @Inject
    private StudentsService studentsService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(studentsService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        StudentsRequest studentRequest = new StudentsRequest();
        studentRequest.setId_room(Integer.parseInt(req.getParameter("id_room")));
        studentRequest.setId(Integer.parseInt(req.getParameter("id")));
        studentRequest.setName((req.getParameter("name")));
        studentRequest.setSex((req.getParameter("sex")));
        studentRequest.setScore(Float.parseFloat(req.getParameter("score")));
        studentRequest.setYearEducation(Integer.parseInt(req.getParameter("yearEducation")));
        studentsService.create(studentRequest);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int studentId = Integer.parseInt(req.getParameter("id"));
        studentsService.delete(studentId);
    }
}