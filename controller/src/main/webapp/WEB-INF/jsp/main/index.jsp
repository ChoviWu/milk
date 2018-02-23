<%--
  Created by IntelliJ IDEA.
  User: qianjy
  Date: 2018/2/23
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="product" items="productList">
    <span>${product}</span>
</c:forEach>

</body>
</html>
