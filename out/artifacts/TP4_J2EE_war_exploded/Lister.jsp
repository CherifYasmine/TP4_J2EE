<%@ page import="com.appa.metier.Utilisateur" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: Yasmine
  Date: 11/12/2020
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>login</th>
        <th>email</th>
        <th>ville</th>
    </tr>
    <%
        Vector<Utilisateur> list = (Vector<Utilisateur>) request.getAttribute("users");
        for (Utilisateur it : list) {%>

    <tr>
        <td>
            <%=it.getIdUser()%>
        </td>
        <td><%=it.getLogin()%>
        </td>

        <td><%=it.getEmail()%>
        </td>
        <td><%=it.getVille()%>
        </td>
    </tr>
    <%}%>
</table>

</body>
</html>
