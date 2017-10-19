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
	
	<div class="container" >

<ul class="pagination pagination-lg">

</ul>



</div>

	
	 <a href="/new" class="btn btn-primary" >글쓰기</a>
</div>


<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
  
  
<script>
$(document).ready(function(e) {
	
	var page = 1;
	
	function adlist(list){
		 
		 var str="";
		 
		 $.each(list, function(index, value) {
			 
			 str+='<tr><td class="text-center">'+value.seq_id+'</td>'
			 		+'<td class="text-center">'+value.board_title+'</td>'
					+'<td class="text-center">'+value.board_writer+'</td>'
					+'<td class="text-center">'+value.board_datetime+'</td>'
					+'<td class="text-center">'+value.board_viewcounter+'</td></tr>'
					
			}); 
		 
		 	$("#showlist").html(str);
		 	
	}
	
	init_list(page);
	
	function init_list(page){
		
		console.log("start~~!~!~!~!~")
		 				
		
		$.ajax({
			  type: "POST",
	    	  url: "/list",
	    	  dataType: 'json',	 	
	    	  data : {
	 			 	
		        	page : page
		        	
		        },
		        
	    	  success: function(re){
	    		console.log("리스트를 받아서 ");
	    		console.log(re.list);
	    		console.log(re.pageMaker);
	    		console.log($("#showlist"))
	    		
	    		adlist(re.list);
	    		printPageing(re.pageMaker);
	    		
	    	
	    			adlist(re);
	    		
	    	  } 
             
		 });
	}
	
	$(".pagination").on("click","a",function(e){
		e.preventDefault();
		console.log("click page")
		console.log($(this).attr('href'));
		
		var page = $(this).attr('href');
		
		init_list(page);
		
		
		
	})
	
	
	
	function printPageing(pageMaker){
		
		var str = "";
		
		if(pageMaker.prev){
			 
			 str +="<li><a href='"+(pageMaker.start-1)+"'> << </a></li>";
			 
		 }
		
		for(var i=pageMaker.start, len = pageMaker.end; i <= len; i++){
			
			var strClass = pageMaker.current == i?'class=active':'';
			
			str += "<li" +strClass+"><a href = '"+i+"'>"+i+"</a></li>";
			
		}
		
		if(pageMaker.next){
			
			str +="<li><a href='"+(pageMaker.end+1)+"'> >> </a></li>";
		}
		
		$(".pagination").html(str);
		
	}
	
	
})


</script>

</body>
</html>