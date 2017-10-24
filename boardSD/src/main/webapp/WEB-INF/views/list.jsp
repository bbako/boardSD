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


<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/list">SeedIt</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/list">main</a></li>
			<li class="active"><a href="/list">Board</a></li>
		</ul>
	</div>
</nav>
  
<div class="container" style="margin-top:5%">
	<div class="jumbotron text-center">
 		<h3>Board List</h3>
 		<h1>${login.member_id} 님이 로그인 하셨습니다.</h1>
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
	
	<div>

		<ul class="pagination">
		
		</ul>
	
	</div>
	<div>
    <div class="input-group">
      <input id="search_i" type="text" class="form-control"  placeholder="Search for...">
      <span class="input-group-btn">
        <button id="search" class="btn btn-default" type="button">Go!</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
	 <a href="/new" class="btn btn-primary" >글쓰기</a>
	 <a href="/user/login" class="btn btn-primary" >로그인</a>
	 <a href="/user/logout" class="btn btn-primary" >로그아웃</a>
	 
</div>

<div id="autocomplete">

			<ul id="ex">
			
			</ul>

</div>

<a href='/showOne'>go</a>


<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
  
  
<script>
$(document).ready(function(e) {
	
	var page = 1;
	var key = "";
	
	function makeTable(list){
		 
		 var str="";
		 
		 $.each(list, function(index, value) {
			 
			 str+='<tr><td class="text-center">'+value.seq_id+'</td>'
			 		+'<td class="text-center"><a>'+value.board_title+'</a></td>'
					+'<td class="text-center">'+value.board_writer+'</td>'
					+'<td class="text-center">'+value.board_datetime+'</td>'
					+'<td class="text-center">'+value.board_viewcounter+'</td></tr>'
					
			}); 
		 
		 	$("#showlist").html(str);
		 	
	}
	
	init_list(page,key);
	
	function init_list(page, key){
		
		console.log("start~~!~!~!~!~")
		 				
		
		$.ajax({
			  type: "POST",
	    	  url: "/list",
	    	  dataType: 'json',	 	
	    	  data : {
	 			 	
		        	page : page,
		        	key : key,
		        	
		        },
		        
	    	  success: function(re){
	    		
	    		makeTable(re.list);
	    		printPageing(re.pageMaker);
	    		
	    		
	    	  } 
             
		 });
	}
	

	
	function printPageing(pageMaker){
		
		var str = "";
		
		if(pageMaker.prev){
			 
			 str +="<li ><a href='"+(pageMaker.start-1)+"'> << </a></li>";
			 
		 }
		
		for(var i=pageMaker.start, len = pageMaker.end; i <= len; i++){
			
			var bold = pageMaker.current == i?"class='active'":'';
			
			str += "<li "+bold+"><a href = '"+i+"'>"+i+"&nbsp"+"</a></li>";
			
		}
		
		if(pageMaker.next){
			
			str +="<li ><a href='"+(pageMaker.end+1)+"'> >> </a></li>";
		}
		
		$(".pagination").html(str);
		
	}
	
	
	$(".pagination").on("click","a",function(e){
		
		e.preventDefault();
		
		var page = $(this).attr('href');
		
		var key = $("#search_i").val();
		
		init_list(page,key);
		
	})
	
	$("#search").on("click",function(e){
		
		e.preventDefault();
		
		console.log("search BTN");
		
		var what = $("#search_i").val();
		
		console.log(what);
		
		$.ajax({
			  type: "POST",
	    	  url: "/list",
	    	  dataType: 'json',	 	
	    	  data : {
	 			 	
		        	page : page,
		        	key : what,
		        	
		        },
		        
	    	  success: function(re){
	    		
	    		makeTable(re.list);
	    		printPageing(re.pageMaker);
	    		
	    	  } 
           
		 });
		
		
	})
	
	$("#search_i").keyup(function(){

			var str = $("#search_i").val();

			$("#search_i").val(str.replace(/(^\s+)|(\s+$)/gm, ""));

			$.ajax({

				url:"/search",

				type:"post",
				
				dataType : 'json',

				data:{

					keyWord:$("#search_i").val()

				},

				success:function(data){
					
					var str = "";
					
					console.log(data);

					$.each(data,(function(index, item){
						
						/* str +="<li><a href="/showOne">"+item.board_title+"</a></li>"; */
					})
					)
					
					$("#ex").html(str);

				}

			});

		});
	
	
	
	
})


</script>

</body>
</html>