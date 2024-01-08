<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.study.models.RoomsEntity" %>
<%@ page import="ru.study.models.StudentsEntity" %>
<%@ page import="ru.study.models.DormitoriesEntity" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>ASC</title>
</head>
<body>
<% List<DormitoriesEntity> uns = (List<DormitoriesEntity>) request.getAttribute("table_university");%>
<table>
    <thead>
    <tr>
        <th>University</th>
        <th>id_dorm</th>
    </tr>
    </thead>
    <tbody>
    <% for (DormitoriesEntity un : uns) { %>
    <tr>
        <td><%= un.getUniversity() %>
        <td><%= un.getId_dorm() %>
    </tr>
    <% } %>
    </tbody>
</table>

<% List<RoomsEntity> rooms = (List<RoomsEntity>) request.getAttribute("table_rooms");%>
<table>
    <thead>
    <tr>
        <th>id_dorm</th>
        <th>id_room</th>
    </tr>
    </thead>
    <tbody>
    <% for (RoomsEntity room : rooms) { %>
    <tr>
        <td><%= room.getId_dorm() %>
        <td><%= room.getId_room() %>
    </tr>
    <% } %>
    </tbody>
</table>

<% List<StudentsEntity> students = (List<StudentsEntity>) request.getAttribute("table_students");%>
<table>
    <thead>
    <tr>
        <th>id_card</th>
        <th>id_room</th>
        <th>name</th>
        <th>sex</th>
        <th>score</th>
        <th>yearEducation</th>
    </tr>
    </thead>
    <tbody>
    <% for (StudentsEntity student: students) { %>
    <tr>
        <td><%= student.getId() %>
        <td><%= student.getId_room() %>
        <td><%= student.getName() %>
        <td><%= student.getSex() %>
        <td><%= student.getScore() %>
        <td><%= student.getYearEducation() %>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>

