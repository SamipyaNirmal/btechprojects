<%@ include file="getcon.jsp"%>
<%@ page import="java.sql.*"%>
<% String usn=(String)session.getAttribute("LUSN");
 String email=(String)session.getAttribute("LEMAIL");
 String pwd=(String)session.getAttribute("LPWD");
 session.setAttribute("LUSN",usn);
session.setAttribute("LPWD",pwd);
session.setAttribute("LEMAIL",email);
%>
<%ResultSet rs=null;
%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript">
var c=1;
var t=setInterval(fun,2000);
function fun()
{if(c==1)
 { 
 var h=document.getElementById("hill");
 h.src="images/nainital.jpg";
  c=c+1;
  }
  else if(c==2)
  {
  var h=document.getElementById("hill");
 
  h.src="images/shimla.jpg";
  
  c=c+1;
  }
  else if(c==3)
  {
  var h=document.getElementById("hill");
 
  h.src="images/manali.jpg"
  
  c=c+1;
  }
else if(c==4)
  {
  var h=document.getElementById("hill");
 
  h.src="images/munnar.jpg";
 
  c=c+1;
  }
  else if(c==5)
  {
  var h=document.getElementById("hill");
 
  h.src="images/coorg.jpg";
  
  c=1;
  }
}
</script>
<style>
* {
    box-sizing: border-box;
}
body
			
			{background-color:white;
	font-family: 'Open Sans', sans-serif;
	font-family: "Roboto", Helvetica, Arial, sans-serif;
	font-size: 13px;
	color:#B50D0D ;
	}
.button {
  cursor: pointer;
  width: 20%;
  border-radius: 7px;
  background:#B50D0D ;
  color: #FFF;
  margin: 10px 100px 15px 300px;
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

  div.img {
    border: 2px solid #ccc;
align}

div.img:hover {
    border: 3px solid #777;
}

div.img img {
    width: 100%;
    height: auto;
	border-width:5px;
}
div.desc {
    padding: 15px;
    text-align: center;
	background-color:white;
}
.responsive {
    padding: 0 6px;
    float: right;
    width:75%;
	padding-bottom:25px;
}

@media only screen and (max-width: 700px){
    .responsive {
        width: 49.99999%;
        margin: 6px 0;
	}
}

@media only screen and (max-width: 500px){
    .responsive {
        width: 100%;
		
    }
}
.menu {
    width: 35%;
    float: left;
    padding: 70px;
	
    
}
.main {
    width: 65%;
    float: right;
    padding-right: 250px;
   
}
h1, h2, h3 {
	margin: 0;
	padding: 0;
	font-weight: normal;
	font-weight: 200;
	color: #222222;
}

h1 {
	font-size: 2em;
}

h2 {
	font-size: 2.8em;
}

h3 {
	font-size: 1.6em;
}

p, ul, ol {
	margin-top: 0;
	line-height: 180%;
}

ul, ol {
}

a {
	color: #B50D0D;
}

a:hover {
	text-decoration: none;
}

#wrapper {
	padding-bottom: 50px;
}

.container {
	width: 1000px;
	margin: 0px auto;
}

/* Header */

#header-wrapper {
	overflow: hidden;
	height: 120px;
	background: #B50D0D;
}

#header {
	overflow: hidden;
	width: 1000px;
	height: 120px;
	margin: 0 auto;
	padding: 0px 0px;
}

/* Logo */

#logo {
	float: left;
	width: 300px;
	margin: 0;
	padding: 0;
	color: #FFFFFF;
}

#logo h1, #logo p {
}

#logo h1,#logo h3 {
	line-height: 120px;
	letter-spacing: -2px;
	font-size: 3em;
	color:white;
}

#logo h1 a {
	color: #FFFFFF;
	text-transform: uppercase;
}

#logo p {
	margin: 0;
	padding: 0px 0 0 0px;
	letter-spacing: -1px;
	font: normal 18px Georgia, "Times New Roman", Times, serif;
	font-style: italic;
	color: #8E8E8E;
}

#logo p a {
	color: #8E8E8E;
}

#logo a {
	border: none;
	background: none;
	text-decoration: none;
	color: #12212F;
}

/* Menu */

#menu {
	float: right;
	width: 500px;
	height: 90px;
	margin: 0 auto;
	padding: 0;
}

#menu ul {
	float: right;
	margin: 0;
	padding: 50px 0px 0px 0px;
	list-style: none;
	line-height: normal;
}

#menu li {
	float: left;
	padding: 0px 0px 0px 0px;
}

#menu a {
	display: block;
	margin-right: 1px;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
	text-align: center;
	font-size: 13px;
	font-weight: 300;
	color: #FFFFFF;
	border: none;
}

#menu a:hover, #menu .current_page_item a {
	text-decoration: none;
	color: #FFFFFF;
}

#menu .current_page_item a,#menu ul li a:hover {
	background: #690606;
	border-radius: 5px;
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
					<li><a href="findex.html">Home</a></li>
					<li><a href="logout.jsp">Logout</a></li>
					
					
				
				</ul></div>
		</div>
	</div>
	</div>
	<div class="menu">
	<h3><b>Welcome <%out.print(usn);%></b></h3>
	<img id="hill" src="images/station.jpg" width="300" height="200" alt="" /><br><br><br>
	<p>Adventure is very popular in india.lets explore!!if u have already explored help other wanderlists to have an experience by sharing urs!!  </p>
	<p>If u wanna try something really adventurous
	,this is the right platform for you.....
	</p>
	<p>As these places are suggested by people like you :)</p>
	<p>Do try it once!!!</p>
	</div>
	<div class=main>
	


<form method=post action="hillupload.jsp">

<input type="submit" class="button" value="Post"/>
<%
try
{
rs=st.executeQuery("select * from hill");
 
while(rs.next())
{
	if(rs.getString("image")==null)
	{out.print(" ");}
	else
	{

	
%>

   
	
  <div class="responsive" >
  <div class="img" >  <div class="desc">
<b>Name:<%=rs.getString("usn") %></b><br>
<b>Contact :<%=rs.getString("email") %></b><br>
<b><%=rs.getString("comm")%></b>
</div>
 <a target="_blank" href="Example\image-folder/<%=rs.getString("image") %>">
<img src="Example\image-folder/<%=rs.getString("image") %>" width="250" height="150" /></a>

</div>

</div>

<%
	}
}
}
catch(Exception e)
{
out.print(""+e.getMessage());
}
%>
</div>
</form>
</body>
<%}%>
</html>
