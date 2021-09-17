<%--
  Created by IntelliJ IDEA.
  User: dychk
  Date: 10.09.2021
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>USER</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
  <div class="container">
    <h1>Ви увійшли як звичаний продаевць!</h1>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
  </div>
</body>
</html>