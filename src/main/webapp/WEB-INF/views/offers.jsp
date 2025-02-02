<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-07
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>수강 신청 조회</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #87CEFA;
        }
    </style>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Year</th>
        <th>Semester</th>
        <th>Course_coude</th>
        <th>Course_name</th>
        <th>Course_category</th>
        <th>Professor</th>
        <th>Credits</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="offer" items="${id_offers}" >
        <tr>
            <td><c:out value="${offer.year}" /></td>
            <td><c:out value="${offer.semester}" /></td>
            <td><c:out value="${offer.course_code}" /></td>
            <td><c:out value="${offer.course_name}" /></td>
            <td><c:out value="${offer.course_category}" /></td>
            <td><c:out value="${offer.professor}" /></td>
            <td><c:out value="${offer.credits}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
