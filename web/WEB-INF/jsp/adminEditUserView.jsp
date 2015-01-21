<%-- 
    Document   : adminEditUserView
    Created on : 2015-01-21, 20:30:18
    Author     : Kamciak
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
            <a href="/contact.htm" title="Skontaktuj się z nami!"><img border="0" src="${pageContext.request.contextPath}/img/kontakt_menu.jpg"></a><br>
            <br />
            <img border="0" src="${pageContext.request.contextPath}/img/inne.jpg">
            <br /><br />
            <a href="http://www.efs.pl/" title="Europejski Fundusz Społeczny"><img border="0" src="${pageContext.request.contextPath}/img/efs.jpg"></a><a href="https://www.przyjaznaszkola.pl/" title="Przyjazna Szkoła"><img border="0" src="${pageContext.request.contextPath}/img/przyjazna_szkola.jpg"></a>
            <br />
        </div>
        <div id="info">
            <!-- TUTAJ ZMIENIAMY ZAWARTOSC -->
            <div class="legend">
                <p>PESEL:</p>
                <p>Imię:</p>
                <p>Nazwisko:</p>
                <p>Kraj:</p>
                <p>Hasło:</p>
                <p>Miasto:</p>
                <p>Kod pocztowy:</p>
                <p>Ulica:</p>
                <p>Numer telefonu:</p>
                <p>Prawa admina:</p>
            </div>
            <div class="fields">
                <spring:nestedPath path="user">
                    <form action="" method="post">
                        <spring:bind path="pesel">
                            <input type="text" name="${status.expression}" value="${current_user.pesel}">
                        </spring:bind>
                        <br />
                        <spring:bind path="name">
                            <input type="text" name="${status.expression}" value="${current_user.name}">
                        </spring:bind>
                        <br />
                        <spring:bind path="surename">
                            <input type="text" name="${status.expression}" value="${current_user.surename}">
                        </spring:bind>
                        <br />
                        <spring:bind path="country">
                            <input type="text" name="${status.expression}" value="${current_user.country}">
                        </spring:bind>
                        <br />
                        <spring:bind path="password">
                            <input type="text" name="${status.expression}" value="${current_user.password}">
                        </spring:bind>
                        <br />
                        <spring:bind path="city">
                            <input type="text" name="${status.expression}" value="${current_user.city}">
                        </spring:bind>
                        <br />
                        <spring:bind path="post_code">
                            <input type="text" name="${status.expression}" value="${current_user.post_code}">
                        </spring:bind>
                        <br />
                        <spring:bind path="street">
                            <input type="text" name="${status.expression}" value="${current_user.street}">
                        </spring:bind>
                        <br />
                        <spring:bind path="phone_number">
                            <input type="text" name="${status.expression}" value="${current_user.phone_number}">
                        </spring:bind>
                        <br />
                        <spring:bind path="admin">
                            <input type="text" name="${status.expression}" value="${current_user.admin}">
                        </spring:bind>
                        <br />
                        <br />
                         <input src="${pageContext.request.contextPath}/img/edytuj.jpg" type="image" value="" />
                    </form>
                </spring:nestedPath>
                    
                </div>
                
                        
        </div>
        <div id="footer">
            <img border="0" src="${pageContext.request.contextPath}/img/stopka.jpg">
        </div>
    </div>
</body>
</html>