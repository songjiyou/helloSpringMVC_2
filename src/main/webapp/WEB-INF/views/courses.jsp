<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jiyou
  Date: 2024-04-14
  Time: 오후 3:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>총 이수 학점 조회</title>
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
<h2 style="text-align: center;">학기별 총 이수 학점</h2>
<table border="1">
    <thead>
    <tr>
        <th>Year</th>
        <th>Semester</th>
        <th>Total Credits</th>
        <th>View Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="entry" items="${totalCreditsByYearAndSemester}">
        <tr>
            <td><c:out value="${entry.key.split('-')[0]}" /></td>
            <td><c:out value="${entry.key.split('-')[1]}" /></td>
            <td><c:out value="${entry.value}" /></td>
            <td><a href="${pageContext.request.contextPath}/coursescredits?year=
            ${entry.key.split('-')[0]}&semester=${entry.key.split('-')[1]}">상세 보기</a></td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr style="background-color: #00BFFF;">
        <td colspan="1">총계</td>
        <td></td>
        <td>
            <c:set var="totalCredits" value="0"/>
            <c:forEach var="entry" items="${totalCreditsByYearAndSemester}">
                <c:set var="totalCredits" value="${totalCredits + entry.value}"/>
            </c:forEach>
            <c:out value="${totalCredits}" />
        </td>
        <td></td>
    </tr>
    </tfoot>
</table>
</body>
</html>







