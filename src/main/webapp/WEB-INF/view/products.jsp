<%@ page import="static java.util.Objects.nonNull" %>
<%@ page import="static java.util.Objects.nonNull" %>
<%@ page import="static java.util.Objects.*" %>
<%@ page import="com.unrgo.javaee_1.model.User" %><%--
  Created by IntelliJ IDEA.
  User: dychk
  Date: 10.09.2021
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>Products</title>
</head>
<body>
<%
    if (nonNull(session) &&
            nonNull(session.getAttribute("login")) &&
            nonNull(session.getAttribute("password"))) {
        User.ROLE role = (User.ROLE) session.getAttribute("role");
        if (!role.equals(User.ROLE.ADMIN)) {
            response.sendRedirect("http://localhost:8080/JavaEE_1_war/");
        }
    }else{
        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }%>
<div class="container">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                <a href="#" class="card-link">Card link</a>
                <a href="#" class="card-link">Another link</a>
            </div>
        </div>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>


</body>
</html>
