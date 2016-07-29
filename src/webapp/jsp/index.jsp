<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body style="font-family: verdana; font-size: 14px;">
<h1>${ message }</h1>
<p>
Do you want to visit the <a href="<%=request.getContextPath()%>/customer?return=/customer">Customer Page</a> or the <a href="<%=request.getContextPath()%>/admin?return=/admin">Admin Page</a>?
</p>


</body>
</html>
