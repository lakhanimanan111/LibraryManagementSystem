package com.manan.dbproject.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class DisplayFinesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DbAction model = new DbAction();
		ResultSet rs = model.displayFines();
		
		request.setAttribute("Fines", rs);
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DisplayFinesResult.jsp");
		requestDispatcher.forward(request,response);
	}

}
