<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>

<script type="text/javascript">
function validateForm() {
    var x = document.forms["MyForm"]["bookDetails"].value;
    if (x == "") {
        alert("Search field cannot be empty");
        return false;
    }
}
</script>
</head>
<body>
	<a href="\LibraryManagement\UserInterface.jsp">Home</a>
	<h1>Book Details</h1>
	<form name="MyForm"  action="SearchController" method="post" onsubmit="return validateForm()">
		Enter: <input type="text" name="bookDetails"> <br>
		<input type="submit" value = "Search"/>
	</form>
</body>
</html>