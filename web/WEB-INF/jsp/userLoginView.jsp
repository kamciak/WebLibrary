<%-- 
    Document   : userLoginView
    Created on : 2014-12-17, 20:06:20
    Author     : Kamciak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <spring:nestedPath path="login_data">
        <form action="" method="post">
        <span>PESEL:</span>
        <spring:bind path="pesel">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Hasło:</span>
        <spring:bind path="password">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        
<br />
<input type="submit" value="Zarejestruj">
</form>
</spring:nestedPath>
    </body>
</html>
