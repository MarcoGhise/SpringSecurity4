<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body style="font-family: verdana; font-size: 14px;">
<h1>${ message }</h1>
<h1>Welcome ${username}</h1>
<p>Have a look at the <a href="<%=request.getContextPath()%>/customer">Customer Page</a>!</p>
<p>
    <form id="logout" action="<%=request.getContextPath()%>/logout" method="post" >
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="submit" value="logout" />
    </form>
</p>
</body>
</html>