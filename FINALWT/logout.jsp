<%
String usn=(String)session.getAttribute("LUSN");
 //String email=(String)session.getAttribute("LEMAIL");
 String pwd=(String)session.getAttribute("LPWD");
 session.invalidate();
 response.sendRedirect("index.html");
%>