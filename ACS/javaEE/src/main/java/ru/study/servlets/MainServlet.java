package ru.study.servlets;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.study.services.DormitoriesService;
import ru.study.services.RoomsService;
import ru.study.services.StudentsService;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Inject
    private RoomsService roomsService;
    @Inject
    private StudentsService studentsService;
    @Inject
    private DormitoriesService dormitoriesService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");
        try {
            request.setAttribute("table_rooms", roomsService.getAll());
            request.setAttribute("table_students", studentsService.getAll());
            request.setAttribute("table_university", dormitoriesService.getAll());
            request.getRequestDispatcher("main.jsp").forward(request, response);
        } catch (Exception ignored) {

        }
    }
}
