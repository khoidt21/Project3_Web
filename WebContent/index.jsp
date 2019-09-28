<%-- 
    Author     : vuvan
--%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Animation CSS -->
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet"
>
<link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="resources/css/animate.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
	<section class="text-center animated fadeInDown">
		<div class="container text-center">
			<div>
				<h1 class="logo-name">FU+</h1>
			</div>
			<%
				User u = (User) session.getAttribute("userNow");
				if (session.getAttribute("isNew") != null) {
					if ((boolean) session.getAttribute("isNew")) {
						session.setAttribute("isNew", false);
			%>
			<h3>
				Welcome to the Board,
				<%=u.getUsername()%></h3>
			<p style="padding-bottom: 10px">Click button below to know more</p>
			<%
				} else {
			%>
			<h3>
				Welcome back,
				<%=u.getUsername()%></h3>
			<p style="padding-bottom: 10px">Click button below to know more</p>
			<%
				}
				}
			%>
			<p>
				<a class="btn btn-primary" style="width: 130px" href="./profile.jsp">Profile</a>
			</p>
			<p>
				<a class="btn btn-primary" style="width: 130px"
					href="./userCounter.jsp"
				>User Counter</a>
			</p>
		</div>
	</section>
	<%@ include file="footer.jsp"%>