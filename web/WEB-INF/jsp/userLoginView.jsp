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
                <div id="main_menu_left">
                    
                <c:choose>
                <c:when test="${sessionScope.userPesel == null}">
                <div id="login_labels">
                        <p>PESEL:</p>
                        <p>Hasło:</p>
                    </div>
                    <div id="login_form">
                        <spring:nestedPath path="login_data">
                        <form action="login.htm" method="post">
                                <spring:bind path="pesel">
                                    <input type="text" name="${status.expression}" value="${status.value}">
                                </spring:bind>
                            <spring:bind path="password">
                                <input type="password" name="${status.expression}" value="${status.value}">
                            </spring:bind>
                            <br />
                            <input src="${pageContext.request.contextPath}/img/zaloguj.jpg" type="image" value="">
                            <br />
                        </form>
                    </spring:nestedPath>
                    </div>
                </c:when>

                <c:otherwise>
                    <p> Zalogowano jako: ${sessionScope.userPesel}</p><br /><br />
                </c:otherwise>
                </c:choose>

                    

                    
                    
                </div>

                <div id="menu_left"
                        <a href="index.htm" title="Wróć na sam początek"><img border="0" src="${pageContext.request.contextPath}/img/strona_glowna_menu.jpg"></a><br>
                        <a href="/contact.htm" title="Skontaktuj się z nami!"><img border="0" src="${pageContext.request.contextPath}/img/kontakt_menu.jpg"></a><br>
                        <br />
                        <img border="0" src="${pageContext.request.contextPath}/img/inne.jpg">
                        <br />
                        <br />
                        <a href="http://www.efs.pl/" title="Europejski Fundusz Społeczny"><img border="0" src="${pageContext.request.contextPath}/img/efs.jpg"></a><a href="https://www.przyjaznaszkola.pl/" title="Przyjazna Szkoła"><img border="0" src="${pageContext.request.contextPath}/img/przyjazna_szkola.jpg"></a>
                        <br />
                </div>
            </div>
            <div id="info">
                    <p align="left">
                        <font size="1" face="verdana" color="#000000">
                            <br />
                            <b>Cycki</b><br />
                            <br />
                            <center><i>"Bogactwo i sławę zdobywa się usilną pracą i nauką. Nie dość jest wiedzieć - trzeba starać się swą wiedzę zużytkować; Nie dość chcieć; trzeba czynić".</i></center>
                            <p align="right">/Goethe/</p>

                            <hr align="center" width="400" size="1">
                            <br />
                            <b>Bla bla</b>
                            <br />
                            <br />
                            Yada yada yada
			</font> 
                    </p>
            </div>
            <div id="footer">

                    <img border="0" src="${pageContext.request.contextPath}/img/stopka.jpg">
            </div>
            </div>
</body>
</html>