package com.manan.dbproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class UpdateCheckInController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("ISBN to be checked in: " + request.getParameter("hiddenValue"));
		String isbn[] = (request.getParameter("hiddenValue")).split(",");
		DbAction model = new DbAction();
		model.checkInbooks(isbn);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/CheckinSuccess.jsp");
		requestDispatcher.forward(request,response);
	}
}
