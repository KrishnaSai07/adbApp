<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%><html>
<head>
<title>Home</title>
<base href="/" />
</head>
<body>
	<h1>Welcome to the Employee portal</h1>
	<h2>Anonymous User</h2>
	<c:choose>
		<c:when test="${currentUserName ne null }">
			<strong>Welcome! ${currentUserName}</strong>				
			<a href="logout">Sign out</a>
		</c:when>
		<c:otherwise>
			<a href="admin/login">Sign in as admin</a>
			<a href="user/loginUser">Sign in as user</a>
			<a href="anon/EmployeeList">View Employees</a>
		</c:otherwise>
	</c:choose>
</body>
</html>