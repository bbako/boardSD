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
<div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form id="loginForm" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="inputID" class="form-control" placeholder="ID" required autofocus>
                <input type="password"  id="inputPW" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button id="signin" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->
    
<script>
$(document).ready(function(e) {
	
	
	
	$("#signin").on("click",function(e){
		
		e.preventDefault();
		
		console.log("signin BTN");
		
		var inputID = $("#inputID").val();
		var inputPW = $("#inputPW").val();
		
		
		$.ajax({
			  type: "POST",
	    	  url: "/login",
	    	  dataType: 'text',	 	
	    	  data : {
	 			 	
		        	user_id : inputID,
		        	user_pw : inputPW,
		        	
		        },
		        
	    	  success: function(re){
	    		    		
	    		alert(re);
	    		
	    	  } 
           
		 });
		
		
	})
	
	
	
	
	
	
})


</script>    

</body>
</html>