<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validateForm() {
    var x = document.forms["MyForm"]["cardNumber"].value;
    if (x == "") {
        alert("Please Enter Card Number");
        return false;
    }
}
</script>
</head>
<body>
<a href="\LibraryManagement\UserInterface.jsp">Home</a>
<h1>Previous Fines</h1>
	<form name="MyForm" action="CheckPreviousFinesController" method="post" onsubmit="return validateForm()">
		Card Number: <input type="text" name="cardNumber"> <br>
		<input type="submit" value = "Submit"/>
	</form>
</body>
</html>