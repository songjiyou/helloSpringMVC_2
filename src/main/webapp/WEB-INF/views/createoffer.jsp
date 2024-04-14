<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2024-03-11
  Time: 오후 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>수강 신청 하기</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/main.css" >

</head>
<body>
<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="offer">
    <table class="formtable">
        <tr>
            <td class="label"> Year:</td>
            <td><sf:input class="control" type="text" path="year"/>  <br/>
                <sf:errors path="year" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> Semester:</td>
            <td><sf:input class="control" type="text" path="semester"/> <br/>
                <sf:errors path="semester" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Course_code:</td>
            <td><sf:input class="control" type="text" path="course_code"/> <br/>
                <sf:errors path="course_code" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Course_name:</td>
            <td><sf:input class="control" type="text" path="course_name"/> <br/>
                <sf:errors path="course_name" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Course_category:</td>
            <td><sf:input class="control" type="text" path="course_category"/> <br/>
                <sf:errors path="course_category" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Professor:</td>
            <td><sf:input class="control" type="text" path="professor"/> <br/>
                <sf:errors path="professor" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Credits:</td>
            <td><sf:input class="control" type="text" path="credits"/> <br/>
                <sf:errors path="credits" class="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="신청하기"/> </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
