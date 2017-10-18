<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html lang="en">
<head>
<title>Seed - Board List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main.do">SeedIt</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="main.do">main</a></li>
			<li class="active"><a href="board_list.do">Board</a></li>
		</ul>
	</div>
</nav>
  
<div class="container" style="margin-top:5%">
	<div class="jumbotron text-center">
 		<h3>Board List</h3>
 	</div>
</div>

<div class="container">       
	<table class="table">
		<thead>
			<tr>
				<th class="col-md-1 text-center">No</th>
				<th class="col-md-5 text-left">Title</th>
				<th class="col-md-2 text-center">Writer</th>
				<th class="col-md-2 text-center">Date</th>
				<th class="col-md-1 text-center">Views</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
			<tr>
				<td class="text-center">${list.seq_id}</td>
				<td class="text-center">${list.board_title}</td>
				<td class="text-center">${list.board_writer}</td>
				<td class="text-center">${list.board_datetime}</td>
				<td class="text-center">${list.board_viewcounter}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>