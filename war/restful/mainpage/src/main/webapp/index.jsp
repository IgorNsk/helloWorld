<%--
    Document   : index
    Created on : 31.05.2011, 19:15:19
    Author     : db2inst
--%>

<!--%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Data Access</h1>
        <style type="text/css">
            P {
                border: 1px solid red;
                padding: 10px;
            }
        </style>

        <form name="Submit" action="DbTestServlet">&nbsp;

            <p><strong>Логин:</strong>
                <input type="text" maxlength="25" size="40" name="login"></p>
            <p><strong>Пароль:</strong>
                <input type="password" maxlength="25" size="40" name="password"></p>


        </form>

    </body>
</html-->
<%@ page contentType = "text/html; charset=UTF-8"%>
<%  response.setHeader("Expires", "-1");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    response.sendRedirect("./login");
%>
