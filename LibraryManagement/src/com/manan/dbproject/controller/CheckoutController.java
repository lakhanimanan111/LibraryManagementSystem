package com.manan.dbproject.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class CheckoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String isbn = request.getParameter("isbn");
			System.out.println("ISBN: " + isbn);
			
			String cardNumber = request.getParameter("cardNumber");
			System.out.println("Card Number: " + cardNumber);
			
			DbAction model = new DbAction();
			
			ResultSet rsCard = model.checkIfCardExists(cardNumber);
			ResultSet rsIsbn = model.checkIfIsbnExists(isbn);
			//If book and borrower exists, proceed else throw exception
			if(rsCard.next() && rsIsbn.next()) {
				//Check if number of books checked out by user is less than 3
				ResultSet rsOne = model.checkOutBookCardNumber(cardNumber);
				if(!rsOne.next()) {
					//Check if the user has not paid the fines for atleast one book
					ResultSet rsTwo = model.checkOutBookFinePaid(cardNumber);
					if(!rsTwo.next()) {
						//Check if book is available for checkout
						ResultSet rsThree = model.checkOutBookIsbn(isbn);
						Date date_in = null;
						if(rsThree.next()) {
							date_in = rsThree.getDate("date_in");
							System.out.println("Date: " + date_in);
							if(date_in != null) {
								model.insertBookLoan(isbn, cardNumber);
								model.updateBookAvailabilityCheckOut(isbn);
								model.insertFineEntry(isbn);
								RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckoutSuccess.jsp");
								requestDispatcher.forward(request,response);
							} else {
								System.out.println("Book is already checked out!");
								String message = "Book is already checked out!";
								request.setAttribute("errorMessage", message);
								RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckoutFailure.jsp");
								requestDispatcher.forward(request,response);
							}
						} else {
							System.out.println("Book is checked out for the first time");
							model.insertBookLoan(isbn, cardNumber);
							model.insertFineEntry(isbn);
							model.updateBookAvailabilityCheckOut(isbn);
							RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckoutSuccess.jsp");
							requestDispatcher.forward(request,response);
							}
					} else {
						System.out.println("Fines not paid by the user!");
						String message = "Fines not paid by the user!";
						request.setAttribute("errorMessage", message);
						RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckoutFailure.jsp");
						requestDispatcher.forward(request,response);
					}
				}  else {
					System.out.println("Maximum checkout limit reached for this user!");
					String message = "Maximum checkout limit reached for this user!";
					request.setAttribute("errorMessage", message);
					RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckoutFailure.jsp");
					requestDispatcher.forward(request,response);
				}
			} else {
				throw new SQLException();
			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckOutError.jsp");
			requestDispatcher.forward(request,response);
		}
		System.out.println("End Book Checkout!!");
	}
}
