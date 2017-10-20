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

<div class="container" style="margin-top:5%">
	<div class="jumbotron text-center">
 		<h3>SIGNUP PAGE</h3>
 	</div>
</div>
<div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card text-center" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form id="loginForm" class="form-signin" action="/user/signup" method="post" >
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" id="inputID" name="member_id" class="form-control" placeholder="ID" required autofocus>
                <input type="text" id="inputName" name="member_name" class="form-control" placeholder="NAME" required autofocus>
                <input type="password"  id="inputPW" name="member_pw" class="form-control" placeholder="Password" required>
                
                <button id="signup" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">등록</button>
            </form>   
           
             
            
        </div><!-- /card-container -->
    </div><!-- /container -->
    
 

</body>
</html>