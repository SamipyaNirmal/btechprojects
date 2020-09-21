<%@ page import ="java.sql.*"%>
<%@ include file="getcon.jsp"%>
<%
String usn=request.getParameter("UN");
String pwd=request.getParameter("PWD");
session.setAttribute("LUSN",usn);
session.setAttribute("LPWD",pwd);
	ResultSet rs=null;
	int flag=0;
	String email=null;
	try
	{
	
	rs=st.executeQuery("select * from tdb");
    while(rs.next())
		{
			if(rs.getString(1).equals(usn)&& rs.getString(2).equals(pwd))
            { flag=1;
			 email=rs.getString(3);
			break;}
		}
      if(flag==1)
		{session.setAttribute("LEMAIL",email);
		  response.sendRedirect("findex.html");
		}
		else
			response.sendRedirect("login2.html");
	}
	catch(Exception e)
	{out.print("<h2>"+e+"<h2>");}
	
		%>
