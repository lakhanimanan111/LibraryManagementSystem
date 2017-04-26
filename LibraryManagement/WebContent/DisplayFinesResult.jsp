<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="\LibraryManagement\UserInterface.jsp">Home</a>
<table style="width:100%" border = "1">

   	<tr>
        <td>Card Id</td>
        <td>Total Fines</td>
   	</tr>
   	
   	<%
   	try {
		ResultSet rs = (ResultSet)request.getAttribute("Fines");
		while(rs.next()) {
   	
   	%>
   	
   	<tr>
   		<td><% out.print(rs.getInt("card_id")); %></td>
   		<td><% out.print(rs.getDouble("total")); %></td>
   	</tr>
   	
   	<%
		}
		rs.close();
	}
	catch(Exception e)
	{
    e.printStackTrace();
	}
   	
   	%>
   	
</table>
</body>
</html>