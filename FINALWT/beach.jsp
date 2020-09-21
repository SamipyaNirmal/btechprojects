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
  position: relative;
  z-index: 1;
  background: transparent;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
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
.button5 {
    background-color: white;
    color: black;
    border: 2px solid #555555;
text-decoration:none;
	position:relative; right:15px; top:35px;
}

.button5:hover {
    background-color: #555555;
    color: white;
}
.button {
    background-color:black;
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}
</style>
</head>
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
					<li><a href="logout.html">Logout</a></li>
					
					
				
				</ul></div>
		</div>
	</div>
	</div>
	<div class="login-page">
  <div class="form">
    
    <form action="insertadv.jsp"  method="post" enctype="multipart/form-data"name="myForm">

     <input type="file" name="ImageFile" id="ImageFile"  />
<button class="button button5">Submit</button>
    
    </form>
	<!--<%try
	{
	String comm= request.getParameter("COM");
	out.print(comm);
int p=st.executeUpdate("update blog set comm='"+comm+"' where usn='"+usn+"'");
	}
	catch(Exception e)
	{out.print("<h3>"+e+"</h3>");
	}-->
%>
  </div>
</div>

</body>
</html>