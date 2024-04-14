<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <title>학사 정보 시스템</title>

  <style>
    #logout-container {
      float: right;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  <div class="container">
    <div class="navbar-header mx-auto">
      <a class="navbar-brand" href="#">학사 정보 시스템</a>
    </div>

    <div class="text-right">
      <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-primary">login</a>
    </div>
  </div>
</nav>

<br>

<div class="container">
  <div class="row">
    <div class="col-md-4">
      <div class="card">
        <div class="card-body text-center">
          <h5 class="card-title">학년별 이수 학점 조회</h5>
          <p class="card-text">학년별 이수 학점 확인</p>
          <a href="${pageContext.request.contextPath}/courses" class="btn btn-primary d-block mx-auto">조회하기</a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card">
        <div class="card-body text-center">
          <h5 class="card-title">수강 신청 하기</h5>
          <p class="card-text">2024-2학기 미리 수강 신청</p>
          <a href="${pageContext.request.contextPath}/createoffer" class="btn btn-primary d-block mx-auto">신청하기</a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="card">
        <div class="card-body text-center">
          <h5 class="card-title">수강 신청 조회하기</h5>
          <p class="card-text">2024-2학기 수강 신청 목록 확인</p>
          <a href="${pageContext.request.contextPath}/offers" class="btn btn-primary d-block mx-auto">조회하기</a>
        </div>
      </div>
    </div>
  </div>
</div>

<br>





<div style="display: flex; justify-content: flex-end; margin-right: 10px;">
  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
  </c:if>

  <form id="logout" action="<c:url value="/logout" />" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
</div>

</body>
</html>







