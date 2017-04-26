<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Management System</title>

<script type="text/javascript">



function display(val){
 var element=document.getElementById('checkbox');
 var s ="";
 if(val=='name')
	 document.write('<script>' +
			 'function validateForm() { ' +
		    'var x = document.forms["MyForm"]["Fname"].value; ' +
		    'var y = document.forms["MyForm"]["Lname"].value; ' +
		    'if (x == "" & y == "") { ' +
		     '   alert("Please Enter Fname and Lname"); ' +
		      '  return false; ' +
		    '} ' +
		    'if (x == "") { ' +
		     '   alert("Please Enter Fname"); ' +
		      '  return false; ' +
		    '} ' +
		    'if (y == "") { ' +
		     '   alert("Please Enter Lname"); ' +
		      '  return false; ' +
		    '} ' +
		'} ' +
	 
	 '<\/script> ' +
			 		'<form name="MyForm" action="CheckInController" method="post" onSubmit=" return validateForm();">' +
	 				'First Name: <input type="text" name="Fname">' +
	 				'Last Name: <input type="text" name="Lname"><br/>' +
	 				'<input type="submit" value = "Submit"/>');
 
 else if(val=='cardNumber')
	 document.write('<script>' +
			 'function validateForm() { ' +
			    'var x = document.forms["MyForm"]["cardNumber"].value; ' +
			    'if (x == "") { ' +
			     '   alert("Please Enter Card Number"); ' +
			      '  return false; ' +
			    '} ' +
			'} ' +
		 '<\/script> ' +
			 '<form name="MyForm" action="CheckInController" method="post" onSubmit=" return validateForm();">' +
					'Card Number: <input type="text" name="cardNumber"><br/>' +
					'<input type="submit" value = "Submit"/>');
 else if(val=='isbn')
	 document.write('<script>' +
			 'function validateForm() { ' +
			    'var x = document.forms["MyForm"]["isbn"].value; ' +
			     'if (x == "") { ' +
			     '   alert("Please Enter ISBN"); ' +
			      '  return false; ' +
			    '} ' +
			'} ' +
		 '<\/script> ' +
			 '<form name="MyForm" action="CheckInController" method="post" onSubmit=" return validateForm();">' +
					'Isbn: <input type="text" name="isbn"><br/>' +
					'<input type="submit" value = "Submit"/>');
 else
	 element.style.display='none';
}

function validateForm(obj) {
    var x = document.forms["MyForm"]["Fname"].value;
    var y = document.forms["MyForm"]["Lname"].value;
    if (x == "" & y == "") {
        alert("Please Enter Fname and Lname");
        return false;
    }
    if (x == "") {
        alert("Please Enter Fname");
        return false;
    }
    if (y == "") {
        alert("Please Enter Lname");
        return false;
    }
}
</script>
</head>

<body>

<a href="\LibraryManagement\UserInterface.jsp">Home</a>
	<h1>CheckIn</h1>
	
	<select name="checkbox" onchange='display(this.value);'>
		<option>Select</option>
  		<option value="name">Name</option>
  		<option value="cardNumber">Card Number</option>
  		<option value="isbn">ISBN</option>
	</select>
</body>
</html>