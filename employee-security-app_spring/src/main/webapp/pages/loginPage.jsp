<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<base href="/" />
</head>
<body>
	<h1>Login</h1>
	<form action="admin_login" method="POST">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<c:if test="${param.err eq true }">
			<p>
				<strong>Incorrect Username or Password!Access Denied</strong>
			</p>
		</c:if>
		<label>User Name: <input type="text" name="unm" id="unm"/></label> <label>Password:
			<input type="password" name="pwd" id="pwd" />
		</label>
		<button>Sign In</button>
	</form>
</body>
</html>



</form>
</body>
</html>