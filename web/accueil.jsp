<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.projetJEE.Book"%>
<%
    List<Book> listBooks = (List<Book>) request.getAttribute("listBooks");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>accueil</h1>
liste des livres:
<table border="1">
    <tr>
        <th>Titre</th>
        <th>Auteur</th>
    </tr>
    <%
        for (Book book : listBooks) {
            String title = book.getTitle();
            String author = book.getAuthor();
    %>
    <tr>
        <td><%=title%></td>
        <td><%=author%></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>