<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body>
<a href="\LibraryManagement\UserInterface.jsp">Home</a>
	<h1>Welcome to library</h1>
	<form action="BorrowerController" method="post">
		<table> 
		<tr> 
			<td align="right">SSN:</td> 
			<td align="left"><input type="text" name="ssn" /></td> 
		</tr> 
		<tr> 
			<td align="right">First Name:</td> 
			<td align="left"><input type="text" name="fname" /></td> 
		</tr> 
		<tr> 
			<td align="right">Last Name:</td> 
			<td align="left"><input type="text" name="lname" /></td> 
		</tr> 
		
		<tr> 
			<td align="right">Address:</td> 
			<td align="left"><input type="text" name="address" /></td> 
		</tr> 
		<tr> 
			<td align="right">City:</td> 
			<td align="left"><input type="text" name="city" /></td> 
		</tr> 
		<tr> 
			<td align="right">State:</td> 
			<td align="left"><input type="text" name="state" /></td> 
		</tr> 
		<tr> 
			<td align="right">Phone:</td> 
			<td align="left"><input type="text" name="phone" /></td> 
		</tr> 
		
		
		<tr> 
			<td></td>
			<td><input type="submit" value="Submit" /> </td>
		</tr>
		</table> 
		</form>

		
</body>
</html>