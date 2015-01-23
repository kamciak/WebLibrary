<%-- 
    Document   : editBookView
    Created on : 2015-01-21, 15:44:17
    Author     : kamil
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <title>WebLibrary</title>
</head>

<body>
    <c:if test="${sessionScope.userGrants==null || sessionScope.userGrants != true}">
            <c:redirect url="index.htm"/>
   </c:if>
    <div id="content">
        <div id="menu_top">
                <a href="index.htm"><img border="0" src="${pageContext.request.contextPath}/img/strona_glowna_top.jpg"></a>
                <a href="contact.htm"><img border="0" src="${pageContext.request.contextPath}/img/kontakt_top.jpg"></a>
                <br />
        </div>
        <div class="clear"></div>
        <div id="top">
            <img src="${pageContext.request.contextPath}/img/top.jpg">
        </div>
        <div id="left">
            <a href="index.htm" title="Wróć na sam początek"><img border="0" src="${pageContext.request.contextPath}/img/strona_glowna_menu.jpg"></a><br>
            <a href="contact.htm" title="Skontaktuj się z nami!"><img border="0" src="${pageContext.request.contextPath}/img/kontakt_menu.jpg"></a><br>
            <br />
            <img border="0" src="${pageContext.request.contextPath}/img/inne.jpg">
            <br /><br />
            <a href="http://www.efs.pl/" title="Europejski Fundusz Społeczny"><img border="0" src="${pageContext.request.contextPath}/img/efs.jpg"></a><a href="https://www.przyjaznaszkola.pl/" title="Przyjazna Szkoła"><img border="0" src="${pageContext.request.contextPath}/img/przyjazna_szkola.jpg"></a>
            <br />
        </div>
        <div id="info">
                <!-- TUTAJ ZMIENIAMY ZAWARTOSC -->
                <h1>Edit book2</h1>
                
                
                <div class="tableContainer" >
                <table >
                    <tr>
                        <td>Tytuł</td>
                        <td >Autor</td>
                        <td >ISBN</td>
                        <td >Rok</td>
                        <td ></td>
                        <td ></td>
                        <c:forEach items="${listOfBooks}" var="book">
                        <tr>
                           <td><c:out value="${book.title}"/></td>
                           <td><c:out value="${book.author}"/></td>
                           <td><c:out value="${book.isbn}"/></td>
                           <td><c:out value="${book.year}"/></td>

                           <td><a href="admineditbook.htm?bookid=${book.id}"><c:out value="Edytuj"/></a></td>
                           <td><a href="admindeletebook.htm?bookid=${book.id}"><c:out value="Usuń"/></a></td>
                       </tr>
                    </c:forEach>
                    </tr>
                    
                </table>
            </div>
                <a href="paneladmin.htm">Powrót</a>
        </div>
        <div id="footer">
            <img border="0" src="${pageContext.request.contextPath}/img/stopka.jpg">
        </div>
    </div>
</body>
</html>
