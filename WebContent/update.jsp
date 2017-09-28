<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="UserServlet" method="post">
	<input type="hidden" name="method" value="update">
	id：<input type="text" name="userId" readonly="readonly" value="${ub.userId }"><br>
	用户名：<input type="text"  name="userName" value="${ub.userName }"><br>
	
	密码：<input type="text" name="userPs" value="${ub.userPs }"><br>
	
	<input type="submit" value="修改">

</form>



</body>
</html>