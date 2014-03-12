<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="Controller" method="post">
    		<table align="center" border="1">
    			<tr><th>Serial Number</th><td><input type ="text" name="t1"></td></tr>
    			<tr><th>Name</th><td><input type ="text" name="t2"></td></tr>
    			<tr><th>Location</th><td><input type ="text" name="t3"></td></tr>
    			<tr><th>Email</th><td><input type ="text" name="t4"></td></tr>
    			<tr><td colspan="2"><input type ="submit" name="t5" value="submit"></td></tr>
    		</table>
    	</form>
  </body>
</html>
