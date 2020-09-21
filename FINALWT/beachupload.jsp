<%@ include file="getcon.jsp"%> 
<%String usn=(String)session.getAttribute("LUSN");
session.setAttribute("LUSN",usn);
String pw=(String)session.getAttribute("LPWD");
session.setAttribute("LPWD",pw);
String email=(String)session.getAttribute("LEMAIL");
session.setAttribute("LEMAIL",email);%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<style>@import url(https://fonts.googleapis.com/css?family=Roboto:300);
.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  background: #F9F9F9;
  padding: 25px;
  margin: 7S0px 0;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}




 .button {
  cursor: pointer;
  width: 30%;
  border-radius: 7px;
  background:#B50D0D ;
  color: #FFF;
  margin: 0 0 5px 120px;
  padding: 10px;
  font-size: 15px;
  
 
}
.button:hover {
  background: #43A047;
  -webkit-transition: background 0.3s ease-in-out;
  
  transition: background-color 0.3s ease-in-out;
}

.button:active {
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}
</style>
</head>
<%
if(usn==null)
{response.sendRedirect("login.html");
}
else
{
%>
<body >
<div id="wrapper">
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<h1>Travellers Adda</h1>
			</div>
			<div id="menu">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="logout.jsp">Logout</a></li>
					
					
				
				</ul></div>
		</div>
	</div>
	</div>
	<div class="login-page">
  <div class="form">
    
    <form action="insertbeach.jsp"  method="post" enctype="multipart/form-data"name="myForm">
 <input type="file" name="ImageFile" id="ImageFile"  />
<input type="text" maxlength=60 placeholder="enter your caption" name="COM">
<button class="button">Submit</button>
   </form>
	

  </div>
</div>

</body>
<%
}%>
</html>