<%--
  Created by IntelliJ IDEA.
  User: dychk
  Date: 10.09.2021
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <title>ADMIN</title>
</head>
<body>
    <div class="container">
        <h1>Ви увійшли як адміністратор!</h1>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
        <a href="${pageContext.request.contextPath}/products">Список товаров</a>


    </div>
</body>
</html>