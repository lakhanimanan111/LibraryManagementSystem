<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>
<script type="text/javascript">
function validateForm() {
    var x = document.forms["MyForm"]["isbn"].value;
    var y = document.forms["MyForm"]["cardNumber"].value;
    if (x == "" & y == "") {
        alert("Please Enter ISBN and Card Number");
        return false;
    }
    if (x == "") {
        alert("Please Enter ISBN");
        return false;
    }
    if (y == "") {
        alert("Please Enter Card Number");
        return false;
    }
}
</script>
</head>
<body>

	<a href="\LibraryManagement\UserInterface.jsp">Home</a>
	<h1>Book Checkout</h1>
	<form name="MyForm" action="CheckoutController" method="post" onsubmit="return validateForm()">
		ISBN: <input type="text" name="isbn"> <br>
		Card Number: <input type="text" name="cardNumber"> <br>
		<input type="submit" name = "Submit"/>
	</form>
</body>
</html>