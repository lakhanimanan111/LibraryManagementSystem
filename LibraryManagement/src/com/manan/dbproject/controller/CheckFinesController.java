package com.manan.dbproject.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class CheckFinesController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cardNumber = request.getParameter("cardNumber");
		
		DbAction model = new DbAction();
		ResultSet rs = model.checkFines(cardNumber);
		
		request.setAttribute("fines", rs);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DisplayFinesBorrower.jsp");
		requestDispatcher.forward(request,response);
	}
}
