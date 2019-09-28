<%-- 
    Author     : vuvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Register</title>

        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="resources/css/plugins/iCheck/custom.css" rel="stylesheet">
        <link href="resources/css/animate.css" rel="stylesheet">
        <link href="resources/css/style.css" rel="stylesheet">
    </head>

    <body class="gray-bg">
	<div class="middle-box text-center loginscreen animated fadeInDown">
            <div>
                <div>
                    <h1 class="logo-name">FU+</h1>
                </div>
                <h3>Sign up new Account</h3>
                <p>Enter Username and Password</p>
                <section class="testimonials text-center">
                    <p><font color="RED">${u.errorToString()}</font></p>
                    <form class="m-t" role="form" action="<%=request.getContextPath()%>/SignupController" method="POST">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="UserName"
                                name="username" value="${u.getUsername()}" minlength="7" autocomplete="off" required>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Password"
                                    name="password" ${u.getPassword()} minlength="9" autocomplete="off" required>
                        </div>
                        <button type="submit"  class="btn btn-primary block full-width m-b">Sign Up</button>
                        <a href="./login.jsp"  class="btn btn-danger block full-width m-b">Cancel</a>
                    </form>
                </section>
                
            </div>
	</div>
	<!-- Mainly scripts -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="resources/js/plugins/iCheck/icheck.min.js"></script>
<%@ include file="footer.jsp"%>
