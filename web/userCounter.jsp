<%-- 
    Author     : vuvan
--%>

<%@page import="controller.UsersData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Counter</title>
        
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
        <%UsersData userdata = (UsersData)application.getAttribute("users");%>
        <section class="showcase text-center loginscreen animated fadeInDown" style="padding: 150px 0px;">
            <div class="container p-0 text-center">
                <h1><b>Online Accounts</b></h1>
                <%--Hien thi so User dang ket noi toi Client--%>
                <p>Members online: <%=userdata.getUsersOnline().size()%></p>
                <%--Hien thi so User da dang ky, ket noi toi Client--%>
                <h3>All Members here:</h3>
                <p><%=userdata.usernamesToString()%> </p>
            </div>
        </section>
<%@ include file="footer.jsp"%>
