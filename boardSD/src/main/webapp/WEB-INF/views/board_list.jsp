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
${pageMaker}
${list}
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="main.do">SeedIt</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="main.do">main</a></li>
			<li class="active"><a href="/list">Board</a></li>
		</ul>
	</div>
</nav>
  
<div class="container" style="margin-top:5%">
	<div class="jumbotron text-center">
 		<h3>Board List</h3>
 	</div>
</div>

<div class="container">       
	<table class="table table-hover table-condensed table-striped">
		<thead>
			<tr>
				<th class="col-md-1 text-center">No</th>
				<th class="col-md-5 text-center">Title</th>
				<th class="col-md-2 text-center">Writer</th>
				<th class="col-md-2 text-center">Date</th>
				<th class="col-md-1 text-center">Views</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
			<tr id="list">
				<td class="text-center">${list.seq_id}</td>
				<td class="text-center">${list.board_title}</td>
				<td class="text-center">${list.board_writer}</td>
				<td class="text-center">${list.board_datetime}</td>
				<td class="text-center">${list.board_viewcounter}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
 	 <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                     <ul class="pagination">
                     <li class="paginate_button" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous">
                     <c:if test="${pageMaker.prev}"><a class="a1" href="${pageMaker.start-1}">&laquo;</a></c:if></li>
                     <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="pagege">
                     <a class="a1" href="${pagege}">
         	<li class="${pageMaker.current ==pagege?'active':''}" aria-controls="dataTables-example" tabindex="0">${pagege}</a></li>
         	</c:forEach> 
                     <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next">
                     <c:if test="${pageMaker.next}"><a class="a1" href="${pageMaker.end+1}">&raquo;</a></c:if></li>
                     </ul>
                     </div>
	
	 <a href="/new" class="btn btn-primary" >±Û¾²±â</a>
</div>

<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
  
 <script>
  
  $(document).ready(function(e) {
  
  	$(".a1").on('click',function(e){
		e.preventDefault();
		
		console.log("pagenation");
		
		console.dir(this.innerText);
		
		var page = this.innerText;
		
		$.ajax({
	           type: "get",
	           url: "/board_list.do",
	           dataType:'Json',
	           data: { 
	            page: page
				},           
	           success: function(data){
	        	   console.log(data);
	               

	           }
			 
			});
		
	
	})
  
  
  
  })
  
  </script>

</body>
</html>