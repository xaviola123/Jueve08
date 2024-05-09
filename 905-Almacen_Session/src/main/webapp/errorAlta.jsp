<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    
    <% String error = (String)request.getAttribute("error"); %>
    <% if (error != null) { %>
        <p><strong><%= error %></strong></p>
        <form action="index.html" method="post">
            <input type="submit" value="Volver a agregar">
        </form>
    <% } %>
</body>
</html>
