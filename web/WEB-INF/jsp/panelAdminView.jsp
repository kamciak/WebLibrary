<%-- 
    Document   : panelAdminView
    Created on : 2015-01-20, 20:41:42
    Author     : Kamciak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.userGrants != true}">
            <c:redirect url="index.htm"/>
        </c:if>
        <h1>Panel ADmin View</h1>
    </body>
</html>
