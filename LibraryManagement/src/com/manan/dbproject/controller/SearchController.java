package com.manan.dbproject.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manan.dbproject.model.DbAction;

public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookDetails = request.getParameter("bookDetails");
		System.out.println("Text to be searched: " + bookDetails);
		
		DbAction model = new DbAction();
		System.out.println("Start Book Search!!");
		
		ArrayList<ResultSet> list = model.getBookDetails(bookDetails);
		
		System.out.println("End Book Search!!");
		
		request.setAttribute("BookSearch", list.get(0));
		request.setAttribute("CountBookSearch", list.get(1));
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/DisplayBookSearch.jsp");
		requestDispatcher.forward(request,response);
		
	}
}
