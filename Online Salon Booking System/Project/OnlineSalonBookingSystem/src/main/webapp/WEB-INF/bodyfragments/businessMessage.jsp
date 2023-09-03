<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${success != null }">
<div style="color: green; size: 12px;" role="alert">${success}</div>
</c:if>
<c:if test="${error != null }">
<div style="color: red; size: 12px;" role="alert">${error}</div>
</c:if>
<c:if test="${msg != null }">
<div style="color: red; size: 12px;" role="alert">${msg}</div>
</c:if>
<c:if test="${warning != null}">
<div style="color: yellow; size: 12px;" role="alert">${warning}</div>
</c:if>
</body>
</html>