package com.manan.dbproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;
import com.manan.dbproject.utilities.Borrower;

public class BorrowerController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Borrower b = new Borrower();
			b.setSsn(request.getParameter("ssn"));
			b.setFname(request.getParameter("fname"));
			b.setLname(request.getParameter("lname"));
			b.setAddress(request.getParameter("address"));
			b.setCity(request.getParameter("city"));
			b.setState(request.getParameter("state"));
			b.setPhone(request.getParameter("phone"));
			
			DbAction model = new DbAction();
			model.insertBorrower(b);
			
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AddBorrowerSuccess.jsp");
			requestDispatcher.forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/AddBorrowerError.jsp");
			requestDispatcher.forward(request,response);
		}
		
		
	}
}
