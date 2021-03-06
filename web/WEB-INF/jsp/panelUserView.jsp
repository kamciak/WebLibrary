<%-- 
    Document   : panelUserView
    Created on : 2015-01-21, 21:52:42
    Author     : Kamil Gzyl
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
    <c:if test="${sessionScope.userPesel == null}">
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
                <h1>Panel użytkownika</h1>
                <hr />
                <center>
                    <a href="usershowbooks.htm"><img src="${pageContext.request.contextPath}/img/wypozycz_ksiazke.jpg" /></a><br />
                    <br />
                    <a href="usershowreservations.htm"><img src="${pageContext.request.contextPath}/img/moje_rezerwacje.jpg" /></a><br />
                    <br />
                    <a href="usershowborrowedbooks.htm"><img src="${pageContext.request.contextPath}/img/moje_wypozyczenia.jpg" /></a><br />
                    <br />
                    <a href="usershowhistory.htm"><img src="${pageContext.request.contextPath}/img/historia.jpg" /></a><br />
                    <br />
                    <a href="usereditdata.htm"><img src="${pageContext.request.contextPath}/img/edytuj_dane.jpg" /></a><br />
                    <br />

                </center>

                <a href="logout.htm">Wyloguj</a>
        </div>
        <div id="footer">
            <img border="0" src="${pageContext.request.contextPath}/img/stopka.jpg">
        </div>
    </div>
</body>
</html>
