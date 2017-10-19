<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
</head>
<body>
${pageMaker}
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
		<tbody id="showlist">
			
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
	
	 <a href="/new" class="btn btn-primary" >글쓰기</a>
</div>
<script>
$(document).ready(function(e) {
	
	var page = 1;
	
	function adlist(list){
		 
		 var str="";
		
		 
		 $.each(list, function(index, value) {
			 
			 console.log(value.seq_id);
			 console.dir($("#showlist"));

			 
			 str+='<tr><td class="text-center">'+value.seq_id+'</td>'
			 		+'<td class="text-center">'+value.board_title+'</td>'
					+'<td class="text-center">'+value.board_writer+'</td>'
					+'<td class="text-center">'+value.board_datetime+'</td>'
					+'<td class="text-center">'+value.board_viewcounter+'</td></tr>'
					
			 
			}); 
		 
		 
		 	$("#showlist").html(str);
		 	
			 
		 
	}
	
	init_list();
	
	function init_list(){
		 
		var page = $(".al").innerText;
		
		 $.ajax({
			  type: "POST",
	    	  url: "/list",
	 		  dataType: 'Json',
	 		  data : {
	 			 	
		        	page : page
		        	
		        },
	    	  success: function(re){
	    		console.log("리스트를 받아서 ");
	    		console.log(re);
	    		console.log($("#showlist"))
	    		
	    			adlist(re);
	    		
	    	  } 
               
		 });
	}
	
	$(".al").on(click,function(e){
		e.preventDefault();
		var = 
		
		
	})
	
})


</script>

</body>
</html>