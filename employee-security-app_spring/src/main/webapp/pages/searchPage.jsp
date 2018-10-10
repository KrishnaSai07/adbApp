<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Search Content</h2>
	<form action="findEmployee" method="POST">
		<label>Search For: <input type="text" name="srhValue" /></label>
		<button name="field" value="name">By Name</button>
		<button name="field" value="dept">By Dept</button>
	</form>
	<c:if test="${pageTitle ne null }">
		<h2>${pageTitle }</h2>
		<c:choose>
			<c:when test="${result ne null}">
				<table>
					<tr>
						<td><strong>Employee#</strong></td>
						<td>${result.empId }</td>
					</tr>
					<tr>
						<td><strong>Name</strong></td>
						<td>${result.empName }</td>
					</tr>
					<tr>
						<td><strong>Basic</strong></td>
						<td>${result.basic }</td>
					</tr>
					<tr>
						<td><strong>Hra</strong></td>
						<td>${result.hra }</td>
					</tr>
					<tr>
						<td><strong>Department</strong></td>
						<td>${result.dept }</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${results ne null and results.size() ne 0}">
				<table>
					<tr>
						<th>Contact#</th>
						<th>Name</th>
						<th>Basic</th>
						<th>Hra</th>
						<th>Department</th>
					</tr>
					<c:forEach items="${results }" var="employee">
						<tr>
							<td>${employee.empId }</td>
							<td>${employee.empName }</td>
							<td>${employee.basic }</td>
							<td>${employee.hra }</td>
							<td>${employee.dept }</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h3>No Such Records Found</h3>
			</c:otherwise>
		</c:choose>
	</c:if>

</body>
</html>