<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>form</title>
</head>
<body>
<%
    if(request.getAttribute("erreur") != null){
%>
<p style="background-color: red">${erreur}</p>
<%
    }
%>
<P> Please fill out this form with your name.</P>
<form action="ServletLogin" method="get">
    <p> Please enter your login and password: </p>
    login: <input NAME="login" type="text" size="12" maxlength=" 20">
    <P> password: <input name="password" type=" text" size=" 12" maxlength=" 20">
    <p> Thank you! </p> <input type="submit">

</form>
</body>
</html>
