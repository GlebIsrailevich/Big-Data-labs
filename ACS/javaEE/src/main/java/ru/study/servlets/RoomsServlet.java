package ru.study.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.models.dto.RoomsRequest;
import ru.study.services.RoomsService;
import ru.study.utils.ObjectMapperFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "roomsServlet", value = "/rooms")
public class RoomsServlet extends HttpServlet {
    private final ObjectMapper objectMapper = ObjectMapperFactory.json();

    @Inject
    private RoomsService roomsService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(roomsService.getAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        RoomsRequest roomsRequest = new RoomsRequest();
        roomsRequest.setId_room(Integer.parseInt(req.getParameter("id_room")));
        roomsRequest.setId_dorm(Integer.parseInt(req.getParameter("id_dorm")));
        roomsService.create(roomsRequest);
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id_dorm = Integer.parseInt(req.getParameter("id_dorm"));
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        roomsService.delete(id_dorm, id_room);
    }
}