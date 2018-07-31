<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<h1>Springmvc Test Page</h1>
	<p>
		<a href="<%=request.getContextPath()%>/test/hello">Hello</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/test/testPathVariable/1">testPathVariable</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/test/testCookieValue">testCookieValue</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/test/testServletAPI?id=1">testServletAPI</a>
	</p>
	<p>
		<a
			href="<%=request.getContextPath()%>/test/testPojo?name=hwc&eye.color=blue">testPojo</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/test/testMap">testMapParam</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/test/testSessionAtt">testSessionAttr</a>
	</p>
	<p>
		<a
			href="<%=request.getContextPath()%>/test/testModelAttr?id=1&name=hexiaowu">testModelAttr</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/success">testNoHandlerPage</a>
	</p>
	<p>
		<a href="<%=request.getContextPath()%>/test/testRedirect">testRedirect</a>
	</p>
	<p>
		<button id="testJson">testJson</button>
	</p>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/scripts/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$("#testJson").click(function() {
			$.ajax({
				url : "<%=request.getContextPath()%>/test/testJson",
				success : function(rs) {
					alert(rs);
				}
			});
		});
	</script>
</body>
</html>