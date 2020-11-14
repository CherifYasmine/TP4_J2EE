<%@ page import="com.appa.metier.Utilisateur" %>
<%@ page import="java.util.Vector" %>
<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Mon User</title>
</head>
<body>
<h1>Vos informations </h1>
<%
    Utilisateur user = (Utilisateur) session.getAttribute("user");
%>
<p>Id:<%=user.getIdUser()%>
</p>
<p>login:<%=user.getLogin()%>
</p>
<p>Pass:<%=user.getPass()%>
</p>
<p>Email:<%=user.getEmail()%>
</p>
<p>Ville:<%=user.getVille()%>
</p>
<br><br>
<form method="get" action="ServletAjouter">

    <label>login:
        <input name="login" type="text" size="12" maxlength=" 20"/>
    </label>

    <label>email:
        <input name="email" type="text" size="12" maxlength="20"/>
    </label>
    <label>password:
        <input name="password" type="text" size="12" maxlength="20"/>
    </label>

    <label>ville:
        <input name="ville" type="text" size="12" maxlength=" 20"/>
    </label>

    <button type="submit">ajouter Utilisateur</button>
</form>
<form action="ServletListe" method="get">
    <button type="submit">Lister Les utilisateurs</button>
</form>
<%--<p>id_user : ${sessionScope.user.getIdUser}</p>
<p>login:${sessionScope.user.getLogin} </p>
<p>password: ${sessionScope.user.getPass}</p>
<p>email: ${sessionScope.user.getEmail} </p>
<p>ville: ${sessionScope.user.getVille} </p>--%>
</body>
</html>
