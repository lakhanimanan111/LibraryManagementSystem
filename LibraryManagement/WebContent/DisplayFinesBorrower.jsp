<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function whichRow(tableID){
	var table = document.getElementById(tableID);
    var inputBoxes = table.getElementsByTagName("tr");
    var isbn = null;
    var cardId = null;
    for (var i = 1; i < inputBoxes.length; i++) {
    	  if(table.rows[i].cells[3].children[0].checked == true) {
    		  cardId = table.rows[i].cells[0].innerHTML;
    		  isbn = table.rows[i].cells[1].innerHTML;
    		  //alert(cardId);
    		  //alert(isbn);
    		}
   	}
    document.myForm.hiddenValueOne.value = cardId;
    document.myForm.hiddenValueTwo.value = isbn;
    return true;
    
}
</script>
</head>
<body>
<a href="\LibraryManagement\UserInterface.jsp">Home</a>
<h1>Books Checked Out Details</h1>
	<table id = "finesDisplay" style="width:100%" border = "1">

   	<tr>
        <td>Card_id</td>
        <td>ISBN</td>
        <td>Fine Amount</td>
        <td></td>
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
				<td><input type="checkbox" id ="name1" onclick="whichRow('finesDisplay')"/>&nbsp;</td>
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
   	
    	<form name="myForm" action="FinePaymentController" method="post"> 
       		<input type="hidden" name="hiddenValueOne" value="0" > 
       		<input type="hidden" name="hiddenValueTwo" value="0" >
       		<input type="submit" value="Submit"/></form>
</body>
</html>