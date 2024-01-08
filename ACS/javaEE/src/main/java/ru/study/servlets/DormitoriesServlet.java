package ru.study.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.models.dto.DormitoriesRequest;
import ru.study.services.DormitoriesService;
import ru.study.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/dorm")
public class DormitoriesServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private DormitoriesService dormitoriesService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(dormitoriesService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        DormitoriesRequest roomsRequest = new DormitoriesRequest();
        roomsRequest.setUniversity(req.getParameter("university"));
        roomsRequest.setId_dorm(Integer.parseInt(req.getParameter("id_dorm")));
        dormitoriesService.create(roomsRequest);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String university = req.getParameter("university");
        int id_dorm = Integer.parseInt(req.getParameter("id_dorm"));
        dormitoriesService.delete(university, id_dorm);
    }
}