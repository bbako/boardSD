<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main.do">SeedIt</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="main.do">Home</a></li>
			<li><a href="board_list.do">Board</a></li>
		</ul>
	</div>
</nav>

<div class="container-fluid text-center">
	<div class="jumbotron">
		<img src="seedit_logo.PNG" class="img-rounded" alt="logo" width="666" height="666">
	</div>
</div>
</body>
</html>
