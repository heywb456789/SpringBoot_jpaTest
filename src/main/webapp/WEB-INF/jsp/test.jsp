<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Test Page</title>
</head>
<body>
    <h2> Heelo! ${name}</h2>
    <div> JSP List TEST </div>
    <c:forEach var ="item" items="${list}" varStatus="idx">
    ${idx.index}, ${item.name} <br />
    </c:forEach>
</body>
</html>