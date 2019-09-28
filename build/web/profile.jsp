<%-- 
    Author     : vuvan
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        
        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">

        <!-- Animation CSS -->
        <link href="resources/css/animate.css" rel="stylesheet">
        <link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
        <link href="resources/css/animate.css" rel="stylesheet">
        <link href="resources/css/style.css" rel="stylesheet">
    </head>
    <body>
        <%User u = (User)session.getAttribute("userNow");%>
        <section class="text-center animated fadeInDown">
            <div>
                <h1 class="logo-name">FU+</h1>
            </div>
            <h3 style="font-size: 25px">Your Profile</h3>
            <div class="text-center">
                <p>Username: <%=u.getUsername()%></p>
                <p>Password: <%=u.getPassword()%></p>
            </div>
        </section>
<%@ include file="footer.jsp"%>
