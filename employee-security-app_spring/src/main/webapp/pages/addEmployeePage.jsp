<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
<head>
<title>Add Contact</title>
</head>
<body>
	<h2>Contact Form</h2>
	<form:form modelAttribute="employee" action="addEmployee" method="POST">
		<table>
			<tr>
				<td><form:label path="empName">Employee Name</form:label></td>
				<td><form:input path="empName" /> <form:errors
						path="empName"></form:errors></td>
			</tr>
			
			<tr>
				<td><form:label path="basic">Basic</form:label></td>
				<td><form:input path="basic" /> <form:errors path="basic"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="hra">HRA</form:label>
				</td>
				<td><form:input path="hra" /> <form:errors
						path="hra"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="dept">Department</form:label></td>
				<td><form:input path="dept" /> <form:errors
						path="dept"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<button>Add Contact</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>