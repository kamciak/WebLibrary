<%-- 
    Document   : userRegistrationView
    Created on : 2014-12-16, 18:01:45
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
        <spring:nestedPath path="user">
        <form action="" method="post">
        <span>Imię:</span>
        <spring:bind path="name">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Nazwisko:</span>
        <spring:bind path="surename">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>PESEL:</span>
        <spring:bind path="pesel">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Hasło:</span>
        <spring:bind path="password">
            <input type="password" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Kraj:</span>
        <spring:bind path="country">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Miasto:</span>
        <spring:bind path="city">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Kod pocztowy:</span>
        <spring:bind path="post_code">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Ulica:</span>
        <spring:bind path="street">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Numer telefonu:</span>
        <spring:bind path="phone_number">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />

<br />
<input type="submit" value="Zarejestruj">
</form>
</spring:nestedPath>
    </body>
</html>
