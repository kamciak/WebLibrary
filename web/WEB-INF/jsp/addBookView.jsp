<%-- 
    Document   : addBookView
    Created on : 2015-01-20, 21:50:13
    Author     : Kamil Gzyl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <title>WebLibrary</title>
</head>
<body>
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
                <h1>Dodaj książkę</h1>
                <hr />
                <div class="legend">
                    <p>Tytuł:</p>
                    <p>Autor:</p>
                    <p>ISBN:</p>
                    <p>Rok:</p>
                </div>
                <div class="fields">
                    
                    <spring:nestedPath path="book">
                    <form action="" method="post">
                    <spring:bind path="title">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <br />
                    <spring:bind path="author">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <br />
                    <spring:bind path="isbn">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <br />
                    <spring:bind path="year">
                        <input type="text" name="${status.expression}" value="${status.value}">
                    </spring:bind>
                    <br />

                    <br />
                    <input type="submit" value="Dodaj">
                    </form>
                    </spring:nestedPath>
                </div>
                <a href="paneladmin.htm">Powrót</a>
        </div>
        <div id="footer">
            <img border="0" src="${pageContext.request.contextPath}/img/stopka.jpg">
        </div>
    </div>
</body>
</html>