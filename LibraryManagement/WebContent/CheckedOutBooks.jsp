<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
<script type="text/javascript">

function whichRow(tableID){
	var table = document.getElementById(tableID);
    var inputBoxes = table.getElementsByTagName("tr");
    var isbn = [];
    for (var i = 1; i < inputBoxes.length; i++) {
    	  if(table.rows[i].cells[5].children[0].checked == true) {
    		  //isbn = table.rows[i].cells[3].innerHTML;
    		  //alert(isbn);
    		  isbn.push(table.rows[i].cells[3].innerHTML);
    		}
   	}
    alert(isbn[0]);
    document.myForm.hiddenValue.value = isbn;
    return true;
}
</script>
</head>
<body>
<a href="\LibraryManagement\UserInterface.jsp">Home</a>
	<h1>Books Checked Out Details</h1>
	<table id = "checkin" style="width:100%" border = "1">

   	<tr>
        <td>Card_id</td>
        <td>Fname</td>
        <td>Lname</td>
        <td>ISBN</td>
        <td>Title</td>
        <td></td>
   	</tr>
   	<%
		try {
			ResultSet rs = (ResultSet)request.getAttribute("result");
			while(rs.next()) {
	
	%>
				<tr>
				<td><% out.print(rs.getString("card_id")); %></td>
				<td><% out.print(rs.getString("fname")); %></td>
				<td><% out.print(rs.getString("lname")); %></td>
				<td id="isbn"><% out.print(rs.getString("isbn")); %></td>
				<td><% out.print(rs.getString("title")); %></td>
				<td><input type="checkbox" id ="name1" />&nbsp;</td>
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
   	
   	<form name="myForm" action="UpdateCheckInController" method="post" onclick="whichRow('checkin')"> 
       		<input type="hidden" name="hiddenValue" value="0" > 
       		<input type="submit" value="Submit"/></form>
</body>
</html>