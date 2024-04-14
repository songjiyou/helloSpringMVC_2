<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jiyou
  Date: 2024-04-14
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Courses</title>
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
            background-color: #A7EEFF;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Courses</h1>
<h2 style="text-align: center;">Year: ${param.year}, Semester: ${param.semester}</h2>
<table border="1">
    <thead>
    <tr>
        <th>Year</th>
        <th>Semester</th>
        <th>Course Name</th>
        <th>Course Category</th>
        <th>Professor</th>
        <th>Credits</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${detailedInfoWithTotalCredits}">
        <tr>
            <td><c:out value="${course['year']}" /></td>
            <td><c:out value="${course['semester']}" /></td>
            <td><c:out value="${course['course_name']}" /></td>
            <td><c:out value="${course['course_category']}" /></td>
            <td><c:out value="${course['professor']}" /></td>
            <td><c:out value="${course['credits']}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

