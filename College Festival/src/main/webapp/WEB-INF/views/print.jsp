<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Print Student Details</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h3> Student Management</h3>
		<a href="/CollegeFestivalImplmentation/student/add" class="btn btn-primary btn-sm mb-3">Add Book</a>
			<table class="table table-bordered table-striped">
			<thead  class="thead-dark">
				<tr>
					<th>Student Id</th>
					<th>Name</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${result}" var="student">
					<tr>
					<td><c:out value="${student.id}"></c:out></td>
					<td><c:out value="${student.name}"></c:out></td>
					<td><c:out value="${student.dept}"></c:out></td>
					<td><c:out value="${student.country}"></c:out></td>
					<td><a href="/CollegeFestivalImplmentation/student/update?id=${student.id}" class="btn btn-info btn-sm">Update</a>
					<a href="/CollegeFestivalImplmentation/student/delete?id=${student.id}" class="btn btn-danger btn-sm" onclick="if(!(confirm('Are you sure to delete this Student Entry?'))) return false">Delete</a>
					</td>></tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>