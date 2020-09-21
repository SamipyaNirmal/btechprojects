<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.util.*, java.io.*" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.File"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="getcon.jsp"%>
 
<%
String comm=null;
try
{
String ImageFile="";
String itemName = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if (!isMultipart)
{
}
else
{
FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List items = null;
try
{
items = upload.parseRequest(request);
}
catch (FileUploadException e)
{
e.getMessage();
}
 
Iterator itr = items.iterator();
while (itr.hasNext())
{
FileItem item = (FileItem)itr.next();
if (item.isFormField())
{
String name = item.getFieldName();
String value = item.getString();
if(name.equals("ImageFile"))
{
ImageFile=value;
}
else if(name.equals("COM"))
	comm=value; 
}
else
{
try
{
itemName = item.getName();
//str=config.getServletContext().getRealPath("/")+"Example\\image-folder\\"+itemName;
File savedFile = new File(config.getServletContext().getRealPath("/")+"Example\\image-folder\\"+itemName);
item.write(savedFile);
}
catch (Exception e)
{
out.println("Error"+e.getMessage());
}
}
}
try
{
	
String usn=(String)session.getAttribute("LUSN");
String pw=(String)session.getAttribute("LPWD");

String email=(String)session.getAttribute("LEMAIL");
session.setAttribute("LUSN",usn);
session.setAttribute("LPWD",pw);
session.setAttribute("LEMAIL",email);


int p=st.executeUpdate("insert into anci values( '"+itemName+"','"+ comm+"','"+usn+"','"+email+"')");

response.sendRedirect("ancient.jsp");}

        
catch(Exception el)
{
out.println("Inserting error"+el.getMessage());
}
}
}
catch (Exception e){
out.println(e.getMessage());
}
%>
