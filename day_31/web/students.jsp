<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.atguigu.javaweb.mvc.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
	%>
	<table border="1" cellpadding="10" cellspacing="0" align="center">
		<tr>
			<th>flow_id</th>
			<th>type</th>
			<th>id_card</th>
			<th>exam_card</th>
			<th>student_name</th>
			<th>location</th>
			<th>grade</th>
			<th>delete</th>
		</tr>
			<%
				for (Student student : students) {
			%>
		
		<tr>
			<th><%=student.getFlow_id()%></th>
			<th><%=student.getType()%></th>
			<th><%=student.getId_card()%></th>
			<th><%=student.getExam_card()%></th>
			<th><%=student.getStudent_name()%></th>
			<th><%=student.getLocation()%></th>
			<th><%=student.getGrade()%></th>
			<th><a href="deleteStudent?flow_id=<%=student.getFlow_id()%>">delete</a></th>
		</tr>
			<%
				}
			%>
		
	</table>

</body>
</html>


















