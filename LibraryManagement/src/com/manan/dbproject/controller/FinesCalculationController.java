package com.manan.dbproject.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class FinesCalculationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DbAction model = new DbAction();
		model.refreshFinesTable();
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/FinesRefreshSuccess.jsp");
		requestDispatcher.forward(request,response);
	}
}
