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
</head>
<body>

<div class="container">
  <div class="panel-group">
  

  

    <div class="panel panel-info">
      <div class="panel-heading">새글쓰기</div>
      <div class="panel-body">
      
      <form>
		  <div class="form-group">
		    <label for="exampleInputEmail1">제 목</label>
		    <input type="text" class="form-control" id="title" placeholder="title">
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleTextarea">내 용</label>
		    <textarea class="form-control" id="content" rows="5">content</textarea>
		  </div>
		  
		  <div class="form-group">
		    <label for="exampleInputEmail1">글쓴이</label>
		    <input type="text" class="form-control" id="writer" placeholder="writer">
		  </div>
		  
		  <button  id="submit" class="btn btn-primary">Submit</button>
		  <a href="board_list.do" class="btn btn-primary" >Cancel</a>
		</form>




	</div>
    </div>

  
  </div>
</div>




<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>

<script>
$(document).ready(function(e) {
	
	$("#submit").on('click',function(e){
		e.preventDefault();
		
		console.log("submit");
		
		 var title = $("#title").val();
		 var content = $("#content").val();
		 var writer = $("#writer").val();
		 
		 console.log(title);
		 console.log(content);
		 console.log(writer);
		 
		 $.ajax({
			type: "post",
			url: "/new",
			data:{ 
			board_title: title,
			board_content: content, 
			board_writer:writer
				},
			type: "post",
			url: "/new",
			data: { 
			board_title: title,
			board_content: content, 
			board_writer:writer
			},
			success: function(){
			alert("정송 됨");
			
			location.href = "/list";
			}
		
		});
	
	})
	
})

</script>

</body>
</html>