<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>success page</h1>
	<p>${requestScope.date }</p>
	<p>request: ${requestScope.person}</p>
	<p>request: ${requestScope.sobj1}</p>
	<p>request: ${requestScope.sobj2}</p>
	<p>request: ${requestScope.sobj3}</p>
	<p>session: ${sessionScope.sobj1}</p>
	<p>session: ${sessionScope.sobj2}</p>
	<p>session: ${sessionScope.sobj3}</p>
</body>
</html>