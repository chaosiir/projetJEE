<%@ page import="com.projetJEE.User.User" %><%--
  Created by IntelliJ IDEA.
  User: Colin
  Date: 04/04/2019
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User)request.getSession().getAttribute("user");
    String username = user.getLogin();
    String pageName = (String)request.getAttribute("pageName");
    User.Rights rights = user.getRights();
%>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<nav class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href="./Home">Home</a>

    <div style="display:flex; flex-grow: 1">
        <ul class="navbar-nav mr-auto">
            <%
                if(pageName.equals("/Students.jsp")){ %>
            <li class="nav-item active">
                <a class="nav-link" href="./Students" style="alignment: left">Students list</a>
            </li>
            <%
                } else { %>
            <li class="nav-item">
                <a class="nav-link" href="./Students" style="alignment: left">Students list</a>
            </li>
            <%
                }
            %>

            <%
                if(pageName.equals("/Groups.jsp")){ %>
            <li class="nav-item active">
                <a class="nav-link" href="./Groups" style="alignment: center">Groups list</a>
            </li>
            <%
                } else { %>
            <li class="nav-item">
                <a class="nav-link" href="./Groups" style="alignment: center">Groups list</a>
            </li>
            <%
                }
            %>
            <%
                if(rights==User.Rights.ADMIN) {
            %>
                <%
                if(pageName.equals("/Users.jsp")){ %>
                <li class="nav-item active">
                    <a class="nav-link" href="./Users" style="alignment: left">Users list</a>
                </li>
                <%
                } else { %>
                <li class="nav-item">
                    <a class="nav-link" href="./Users" style="alignment: left">Users list</a>
                </li>
                <%
                    }
                %>
            <% } %>
        </ul>
        <!-- Dropdown -->
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    <%=username%>
                </a>
                <div class="dropdown-menu dropdown-menu-right">
                    <a class="dropdown-item" href="./update" >Update Your account </a>
                    <a class="dropdown-item" href="./login"></i>Log out</a>
                </div>
            </li>
        </ul>
    </div>

</nav>
</html>
