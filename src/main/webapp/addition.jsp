<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suma de 2 numeros</title>
</head>
<body>

<%
    int num1 =Integer.parseInt( request.getParameter("number1"));
  int num2 =Integer.parseInt( request.getParameter("number2"));
 %>
La suma de <%=num1 %> y <%=num2 %> == <%=num1+num2 %>
</body>
</html>