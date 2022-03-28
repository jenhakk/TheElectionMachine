<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Election machine</title>
<link rel="stylesheet" href="/css/style2.css" />
</head>
<body>
	<div class="first">
		<h2 class="head">Election machine</h2>
		<table>
			<tr>
				<th>Voting number</th>
				<th>Last name</th>
				<th>First name</th>
				<th>More information</th>
			</tr>
			<c:forEach var="candidate" items="${requestScope.candilist}">
				<tr>
					<td><c:out value="${candidate.id}" /></td>
					<td><c:out value="${candidate.name}" /></td>
					<td><c:out value="${candidate.fname}" /></td>
					<td><c:out value="${candidate.promo}" /></td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>