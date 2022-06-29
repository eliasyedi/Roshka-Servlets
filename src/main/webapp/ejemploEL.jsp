<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="estilos/login.css"></link>
</head>
<body>
<h1>Usando JSP</h1>
<label> Nombre:</label>
<span>${usuario.nombre}</span>
<label> Apellido:</label>
<span>${usuario.apellido}</span>
<label> Email:</label>
<span>${usuario.email}</span>
</body>
</html>