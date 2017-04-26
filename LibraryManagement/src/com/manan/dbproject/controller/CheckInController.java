package com.manan.dbproject.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class CheckInController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fname = request.getParameter("Fname");
		System.out.println("Fname: " + fname);
		
		String lname = request.getParameter("Lname");
		System.out.println("Lname: " + lname);
		
		String cardNumber = request.getParameter("cardNumber");
		System.out.println("Card Number: " + cardNumber);
		
		String isbn = request.getParameter("isbn");
		System.out.println("ISBN: " + isbn);
		
		DbAction model = new DbAction();
		if(fname != null && lname != null) {
			ResultSet rsName = model.getCheckedOutBooksName(fname, lname);
			request.setAttribute("result", rsName);
			
		} else if(cardNumber != null) {
			ResultSet rsCardNumber = model.getCheckedOutBooksCardNumber(cardNumber);
			request.setAttribute("result", rsCardNumber);
		} else {
			ResultSet rsIsbn = model.getCheckedOutBooksIsbn(isbn);
			request.setAttribute("result", rsIsbn);
		}
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckedOutBooks.jsp");
		requestDispatcher.forward(request,response);
		
	}
}
