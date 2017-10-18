<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</head>
<body>
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
  <button id="cancel" class="btn btn-primary">Cancel</button>
</form>

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
           data: { 
            board_title: title,
            board_content: content, 
            board_writer:writer
			},           
           success: function(){
               alert("정송 됨");               
           }
		 
		});
	
	})
})

</script>

</body>
</html>