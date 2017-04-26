package com.manan.dbproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.manan.dbproject.utilities.Borrower;
import com.manan.dbproject.utilities.DatabaseConnection;
import com.manan.dbproject.utilities.Queries;

public class DbAction {
	
	/*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/lcd";
	static final String USER = "root";
	static final String PASS = "";*/
	Connection conn = null;
	PreparedStatement ps = null;
	   
	public ArrayList<ResultSet> getBookDetails(String bookDetails) {
		
		ArrayList<ResultSet> list = new ArrayList<>();
		ResultSet rsOne = null;
		ResultSet rsTwo = null;
		try	{
			
			  String paramOne = "%" + bookDetails + "%";
			  String paramTwo = bookDetails + "%";
			  
		      System.out.println("Connecting to database...");
		      conn = DatabaseConnection.getConnection();
		      
		      ps = conn.prepareStatement(Queries.SEARCH_BOOKS);
		      ps.setString(1, paramOne);
		      ps.setString(2, paramTwo);
		      ps.setString(3, paramOne);
		      rsOne = ps.executeQuery();
		      
		      ps = conn.prepareStatement(Queries.COUNT_SEARCH_BOOKS);
		      ps.setString(1, paramOne);
		      ps.setString(2, paramTwo);
		      ps.setString(3, paramOne);
		      rsTwo = ps.executeQuery();
		      
		      list.add(rsOne);
		      list.add(rsTwo);
		      
		   } catch (Exception e) {
			   e.printStackTrace();
		   	}
		return list;
	}
	
	public ResultSet checkIfCardExists(String cardNumber) {
		ResultSet rs = null;
	     try {
	    	 
	    	 System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.CHECK_IF_CARD_EXISTS);
		     ps.setString(1, cardNumber);
	    	 rs = ps.executeQuery();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
	     return rs;
	}
	
	public ResultSet checkIfIsbnExists(String isbn) {
		ResultSet rs = null;
	     try {
	    	 
	    	 System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.CHECK_IF_ISBN_EXISTS);
		     ps.setString(1, isbn);
	    	 rs = ps.executeQuery();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
	     return rs;
	}
	
	/*
	 * This method executes query to check if book is checked out already
	 */
	public ResultSet checkOutBookIsbn(String isbn) {
		 
		ResultSet rs = null;
	     try {
	    	 
	    	 System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.BOOK_CHECKOUT_ISBN);
		     ps.setString(1, isbn);
	    	 rs = ps.executeQuery();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	     
	     return rs;
	}

	public ResultSet checkOutBookCardNumber(String cardNumber) {
		int cardNumberInt = Integer.parseInt(cardNumber);
		ResultSet rs = null;
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.BOOK_CHECKOUT_CARDNUMBER);
		     ps.setInt(1, cardNumberInt);
	    	 //ps.setString(1, cardNumber);
	    	 rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet checkOutBookFinePaid(String cardNumber) {
		ResultSet rs = null;
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.BOOK_CHECKOUT_CHECKFINES);
		     ps.setString(1, cardNumber);
	    	 rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void insertBookLoan(String isbn, String cardNumber) {
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.INSERT_BOOK_LOAN);
		     ps.setString(1, isbn);
		     ps.setString(2, cardNumber);
	    	 ps.executeUpdate();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void updateBookAvailabilityCheckOut(String isbn) {
		try {
			conn = DatabaseConnection.getConnection();
			ps = conn.prepareStatement(Queries.UPDATE_BOOK_AVAILABILITY_CHECKOUT);
	    	ps.setString(1, isbn);
	    	ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertFineEntry(String isbn) {
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.INSERT_FINE);
		     ps.setString(1, isbn);
	    	 ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ResultSet getCheckedOutBooksName(String fname, String lname) {
		
		ResultSet rs = null;
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.BOOK_CHECKIN_NAME);
		     ps.setString(1, fname);
		     ps.setString(2, lname);
	    	 rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getCheckedOutBooksCardNumber(String cardNumber) {
		
		ResultSet rs = null;
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.BOOK_CHECKIN_CARDNUMBER);
		     ps.setString(1, cardNumber);
	    	 rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet getCheckedOutBooksIsbn(String isbn) {
		
		ResultSet rs = null;
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.BOOK_CHECKIN_ISBN);
		     ps.setString(1, isbn);
	    	 rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void checkInbooks(String isbn[]) {
		try {
			
			System.out.println("Connecting to database...");
	    	 conn = DatabaseConnection.getConnection();
	    	 
	    	 ps = conn.prepareStatement(Queries.UPDATE_BOOKLOANS_ON_BOOK_CHECKIN);
		     for (int i = 0; i < isbn.length; i++) {
		    	 ps.setString(1, isbn[i]);
		    	 ps.executeUpdate();
			}
		     
		     ps = conn.prepareStatement(Queries.UPDATE_BOOK_ON_BOOK_CHECKIN);
	    	 
		     for (int i = 0; i < isbn.length; i++) {
		    	 ps.setString(1, isbn[i]);
		    	 ps.executeUpdate();
		     }
	    	
		     
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertBorrower(Borrower b) throws Exception {
	    	 conn = DatabaseConnection.getConnection();
	    	 ps = conn.prepareStatement(Queries.ADD_NEW_BORROWER);
		     ps.setString(1, b.getSsn());
		     ps.setString(2, b.getFname());
		     ps.setString(3, b.getLname());
		     ps.setString(4, b.getAddress());
		     ps.setString(5, b.getCity());
		     ps.setString(6, b.getState());
		     ps.setString(7, b.getPhone());
	    	 ps.executeUpdate();
		
	}
	
	public void refreshFinesTable() {
		try {
	    	 conn = DatabaseConnection.getConnection();
	    	 
	    	 ps = conn.prepareStatement(Queries.CALCULATE_FINES_NOT_RETURNED);
	    	 ps.executeUpdate();
	    	 
	    	 ps = conn.prepareStatement(Queries.CALCULATE_FINES_RETURNED);
	    	 ps.executeUpdate();
	    	 
	    	 ps = conn.prepareStatement(Queries.ZERO_FINE_PAID_UPDATE);
	    	 ps.executeUpdate();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ResultSet displayFines() {
		ResultSet rs = null;
		try {
	    	 conn = DatabaseConnection.getConnection();
	    	 
	    	 ps = conn.prepareStatement(Queries.DISPLAY_FINES);
	    	 rs = ps.executeQuery();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet checkFines(String cardNumber) {
		ResultSet rs = null;
		try {
	    	 conn = DatabaseConnection.getConnection();
	    	 
	    	 ps = conn.prepareStatement(Queries.CHECK_FINES);
	    	 ps.setString(1, cardNumber);
	    	 rs = ps.executeQuery();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet payFines(String cardNumber, String isbn) {
		ResultSet rs = null;
		try {
			
	    	 conn = DatabaseConnection.getConnection();
	    	 
	    	 ps = conn.prepareStatement(Queries.INSERT_PREVIOUS_FINES);
	    	 ps.setString(1, cardNumber);
	    	 ps.setString(2, isbn);
	    	 ps.executeUpdate();
	    	 
	    	 ps = conn.prepareStatement(Queries.PAY_FINES);
	    	 ps.setString(1, cardNumber);
	    	 ps.setString(2, isbn);
	    	 ps.executeUpdate();
	    	 
	    	 ps = conn.prepareStatement(Queries.CHECK_IF_PAID);
	    	 ps.setString(1, cardNumber);
	    	 ps.setString(2, isbn);
	    	 rs = ps.executeQuery();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet checkPreviousFines(String cardNumber) {
		ResultSet rs = null;
		try {
	    	 conn = DatabaseConnection.getConnection();
	    	 
	    	 ps = conn.prepareStatement(Queries.CHECK_PREVIOUS_FINES);
	    	 ps.setString(1, cardNumber);
	    	 rs = ps.executeQuery();
	    	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
