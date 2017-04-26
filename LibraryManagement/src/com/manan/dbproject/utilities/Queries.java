package com.manan.dbproject.utilities;

public class Queries {

	public static String SEARCH_BOOKS = "select b.isbn as ISBN, b.title as Title, ba.author_id as AUTHOR_ID, a.name as AUTHOR_NAME, b.availability as Availability " + 
										"from book b " +
										"join book_authors ba " +
										"on b.isbn = ba.isbn " +
										"join authors a " +
										"on ba.author_id = a.author_id " +
										"where 	ba.isbn IN(select isbn from book where title like ?) " +
										"OR " +
										"ba.isbn IN (select isbn from book where isbn like ?) " +
										"OR " +
										"ba.author_id IN (select author_id from authors where name like ?) " + 
										"order by b.isbn";
	
	public static String COUNT_SEARCH_BOOKS = 	"select b.isbn as ISBN, COUNT(*) AS X " +
												"from book b " +  
												"join book_authors ba " +
												"on b.isbn = ba.isbn " +
												"join authors a " +
												"on ba.author_id = a.author_id " + 
												"where 	(ba.isbn IN (select isbn " + 
												"from book " +
												"where title like ?) " +
												"OR " +
												"ba.isbn IN (select isbn " + 
												"from book " +
												"where isbn like ?) " +
												"OR " +
												"ba.author_id IN (select author_id " +
												"from authors " +  
												"where name like ?)) " +
												"GROUP BY b.isbn " + 
												"ORDER BY b.isbn";
	
	public static String CHECK_IF_CARD_EXISTS = "select * from borrower where card_id = ?";
	
	
	public static String CHECK_IF_ISBN_EXISTS = "select * from book where isbn = ?";
	
	public static String BOOK_CHECKOUT_ISBN = "Select date_in from book_loans " + 
										 		"where isbn  = ?";
	
	public static String BOOK_CHECKOUT_CARDNUMBER = "select card_id,count(*) as c from book_loans " +
													"where card_id = ? and date_in is null " +
													"group by card_id " +
													"having count(*) = 3";
	
	
	
	public static String BOOK_CHECKOUT_CHECKFINES = "select * " +
													"from fines f " +
													"join book_loans bl " +
													"on f.loan_id = bl.loan_id " +
													"where card_id = ? and not f.fine_amt = 0";
	
	public static String INSERT_BOOK_LOAN = "Insert into book_loans (isbn, card_id, date_out, due_date, date_in) " + 
											"values (?, ?, curdate(), date_add(date_out, interval 14 day), null)";
	
	public static String UPDATE_BOOK_AVAILABILITY_CHECKOUT = 	"update book " +
																"set availability = 0 " +
																"where isbn = ?";
	
	public static String INSERT_FINE = 	"Insert into fines (loan_id,fine_amt,paid) " +
										"select loan_id, 0, false " +
										"from book_loans " +
										"where isbn = ? and date_in is null";

	public static String BOOK_CHECKIN_NAME = "select bl.card_id, bo.fname, bo.lname, b.isbn, b.title " +
											"from book b " +
											"join book_loans bl " + 
											"on b.isbn = bl.isbn " +
											"join borrower bo " +
											"on bl.card_id = bo.card_id " +
											"where bo.fname = ? AND bo.lname = ? and date_in is null";
	
	public static String BOOK_CHECKIN_ISBN = "select bl.card_id, bo.fname, bo.lname, b.isbn, b.title " +
											"from book b " +
											"join book_loans bl " + 
											"on b.isbn = bl.isbn " +
											"join borrower bo " +
											"on bl.card_id = bo.card_id " +
											"where bl.isbn = ? and date_in is null";
	
	public static String BOOK_CHECKIN_CARDNUMBER = "select bl.card_id, bo.fname, bo.lname, b.isbn, b.title " +
													"from book b " +
													"join book_loans bl " + 
													"on b.isbn = bl.isbn " +
													"join borrower bo " +
													"on bl.card_id = bo.card_id " +
													"where bl.card_id = ? and date_in is null";
	
	
	public static String UPDATE_BOOKLOANS_ON_BOOK_CHECKIN = "update book_loans " +
															"set date_in = curdate(), date_out = null " +
															"where isbn = ? and date_in is null";
	
	public static String UPDATE_BOOK_ON_BOOK_CHECKIN =	"update book " +
														"set availability = 1 " +
														"where isbn = ?";
	
	
	public static String ADD_NEW_BORROWER = "Insert into borrower (ssn, fname, lname, address, city, state, phone) " + 
											"values (?, ?, ?, ?, ?, ?, ?) ";
	
	public static String ZERO_FINE_PAID_UPDATE = "Update fines f " + 
												"join book_loans bl " + 
												"on bl.loan_id = f.loan_id " + 
												"set paid  = " +
												"CASE " + 
												"when datediff(bl.due_date, bl.date_in) > 0 " +
												"then " +
												"1 " +
												"else paid " +
												"END " +
												"where date_in is not null and f.paid = 0 ";
	
	public static String CALCULATE_FINES_RETURNED = "Update fines f " + 
													"join book_loans bl " + 
													"on bl.loan_id = f.loan_id " + 
													"set fine_amt  = " +
													"CASE " + 
													"when datediff(bl.due_date, bl.date_in) < 0 " +
													"then " +
													"-1 * 0.25 * datediff(bl.due_date, bl.date_in) " +
													"else fine_amt " +
													"END " +
													"where date_in is not null and f.paid = 0 ";
	
	public static String CALCULATE_FINES_NOT_RETURNED = "Update fines f " + 
														"join book_loans bl " + 
														"on bl.loan_id = f.loan_id " + 
														"set fine_amt  = " +
														"CASE " + 
														"when datediff(bl.due_date, curdate()) < 0 " +
														"then " +
														"-1 * 0.25 * datediff(bl.due_date, curdate()) " +
														"else fine_amt " +
														"END " +
														"where date_in is null and f.paid = 0";
	
	public static String DISPLAY_FINES = "select bl.card_id, SUM(fine_amt) as total " +
										"from book_loans bl " +
										"join fines f " +
										"on bl.loan_id = f.loan_id " +
										"where f.paid = 0 " +
										"group by bl.card_id";
	
	
	public static String CHECK_FINES = "select bl.card_id, bl.isbn, f.fine_amt " +
										"from book_loans bl " +
										"join fines f " + 
										"on bl.loan_id = f.loan_id " +
										"where f.paid = 0 and bl.card_id = ? ";
	
	public static String CHECK_PREVIOUS_FINES = "select card_id, isbn, fine_amt " +
												"from previous_fines " +
												"where card_id = ?";
	
	public static String INSERT_PREVIOUS_FINES = 	"Insert into previous_fines " +
													"(card_id, isbn, fine_amt) " + 
													"select bl.card_id, bl.isbn, f.fine_amt " +
													"from book_loans bl " +
													"join fines f " +
													"on bl.loan_id = f.loan_id " +
													"where bl.card_id = ? and bl.isbn = ? and date_in IS NOT NULL";
	
	public static String PAY_FINES =    "update fines f " +
										"join book_loans bl " +
										"on bl.loan_id = f.loan_id " +
										"set f.fine_amt = 0, f.paid = 1 " +
										"where bl.card_id = ? and bl.isbn = ? and bl.date_in IS NOT NULL";
	
	public static String CHECK_IF_PAID = 	"select f.paid " +
											"from fines f " +
											"join book_loans bl " +
											"on bl.loan_id = f.loan_id " +
											"where bl.card_id = ? and isbn = ? and f.paid = 0";

	
}
