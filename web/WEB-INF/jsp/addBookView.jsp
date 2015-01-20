<%-- 
    Document   : addBookView
    Created on : 2015-01-20, 21:50:13
    Author     : Kamciak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add book</h1>
        <spring:nestedPath path="book_data">
        <form action="" method="post">
        <span>Tytuł:</span>
        <spring:bind path="title">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Autor:</span>
        <spring:bind path="author">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>ISBN:</span>
        <spring:bind path="isbn">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
        <span>Rok: </span>
        <spring:bind path="year">
            <input type="text" name="${status.expression}" value="${status.value}">
        </spring:bind>
        <br />
        
<br />
<input type="submit" value="Dodaj">
</form>
</spring:nestedPath>
    </body>
</html>
