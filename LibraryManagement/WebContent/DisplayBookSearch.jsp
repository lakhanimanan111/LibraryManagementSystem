<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.ResultSet" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
</head>
<body>

	<a href="\LibraryManagement\UserInterface.jsp">Home</a>
	<a href="\LibraryManagement\BookSearch.jsp">Search Books</a>
	
	<h1>List of Books</h1>
	<table style="width:100%" border = "1">

   	<tr>
        <td>ISBN</td>
        <td>Title</td>
        <td>Author Name</td>
        <td>Availability</td>
   	</tr>
	<%
		try {
			ResultSet rsOne = (ResultSet)request.getAttribute("BookSearch");
			ResultSet rsTwo = (ResultSet)request.getAttribute("CountBookSearch");
			while(rsTwo.next()) {
				String isbn = rsTwo.getString("ISBN");
				int count = rsTwo.getInt("X");
				
				rsOne.next();
				String isbnToCompare = rsOne.getString("ISBN");
				String authors  = "";
	%>
	
		<tr><td><%out.print(rsOne.getString("ISBN")); %></td>
       	<td><%out.print(rsOne.getString("Title")); %></td>
	
	<%
				if(isbn.equals(isbnToCompare)) {
					do {
						if(count != 1) {
							//authors = rsOne.getString("AUTHOR_NAME") + ",";
							authors = authors.concat(rsOne.getString("AUTHOR_NAME"));
							authors = authors.concat(",");
						} else {
							//authors = rsOne.getString("AUTHOR_NAME");
							authors = authors.concat(rsOne.getString("AUTHOR_NAME"));
						}
						
						count--;
					} while(count != 0 && rsOne.next());
					System.out.println(authors);
				}
	%>
	
		<td><%out.print(authors);%></td>
		<td><%out.print(rsOne.getString("Availability")); %>
		</tr>
       	
	<%
			}
	%>
   	</table>
   <%
        rsOne.close();
   		rsTwo.close();
   	}
   catch(Exception e)
   {
        e.printStackTrace();
   }
   %>
</body>
</html>