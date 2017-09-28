<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	当前登录人:${ub.userName }
	<hr>
	<form action="UserServlet" method="post">
		用户名：<input type="text" name="userName" value="${userName }"><!--数据回显  -->
		年龄： <input type="text" name="userPassword" value="${userPassword }"> 
		<input type="submit" value="查询">
	</form>
	<hr>
	<table width="800px">
		<c:forEach var="u" items="${userInfo }">
			<tr>
				<td>${u.id }</td>
				<td>${u.name }</td>
				<td>${u.password }</td>
				<td><a href="UserServlet?method=pupdate&userId=${u.userId }">修改</a>
					<a href="#">删除</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>