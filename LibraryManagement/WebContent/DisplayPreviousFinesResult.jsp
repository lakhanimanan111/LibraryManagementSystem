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
<h1>Books Checked Out Details</h1>
	<table id = "finesDisplay" style="width:100%" border = "1">

   	<tr>
        <td>Card_id</td>
        <td>ISBN</td>
        <td>Fine Amount</td>
   	</tr>
   	
   	 	<%
		try {
			ResultSet rs = (ResultSet)request.getAttribute("fines");
			while(rs.next()) {
	
	%>
				<tr>
				<td><% out.print(rs.getString("card_id")); %></td>
				<td><% out.print(rs.getString("isbn")); %></td>
				<td><% out.print(rs.getString("fine_amt")); %></td>
				</tr>
	<%	   		
	   		}
			rs.close();
		} catch(Exception e)
	   		{
	        e.printStackTrace();
	   		}
	%>
   	</table>
</body>
</html>