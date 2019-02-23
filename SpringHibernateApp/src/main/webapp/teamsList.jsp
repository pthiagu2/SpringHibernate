<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teams List</title>
<style type="text/css">
.even {
	background-color: white
}

.odd {
	background-color: gray
}
</style>
</head>
<body>
	<h2>List of Teams</h2>
	<p>Following is the list of the teams, edit them, remove or update.</p>
	<table border="1">
		<tr>
			<th width="10%">Id</th>
			<th width="15%">Name</th>
			<th width="10%">Rating</th>
			<th width="10%">Actions</th>
		</tr>
		<c:forEach var="team" items="${teams}" varStatus="row">
			<c:choose>
				<c:when test="${row.count % 2 == 0}">
					<c:set var="rowStyle" value="even" />
				</c:when>
				<c:otherwise>
					<c:set var="rowStyle" value="odd" />
				</c:otherwise>
			</c:choose>
			<tr class="${rowStyle}">
				<td>${team.id}</td>
				<td>${team.name}</td>
				<td>${team.rating}</td>
				<td><a href="edit/${team.id}.html">Edit</a> <a
					href="delete/${team.id}.html">Delete</a></td>
			</tr>
		</c:forEach>