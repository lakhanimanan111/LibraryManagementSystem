package com.manan.dbproject.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class FinePaymentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cardNumber = request.getParameter("hiddenValueOne");
		String isbn = request.getParameter("hiddenValueTwo");
		System.out.println("Card Id: " + cardNumber);
		System.out.println("Isbn: " + isbn);
		
		DbAction model = new DbAction();
		try {
			ResultSet rs = model.payFines(cardNumber, isbn);
			if(!rs.next()) {
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/FinePaymentSuccess.jsp");
				requestDispatcher.forward(request,response);
			} else {
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/FinePaymentFailure.jsp");
				requestDispatcher.forward(request,response);
			}
		} catch (Exception e) {
			
		}
		
	}

	
}
