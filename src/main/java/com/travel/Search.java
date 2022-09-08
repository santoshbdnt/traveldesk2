package com.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String spokeName = request.getParameter("spoke");
		String q;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			
			System.out.println("Date :"+date);
			System.out.println("Full Name : "+name);
			System.out.println("id :"+id);
			
			
			if(date.equals("") && name.equals("") && spokeName.equals("")) {
				q = "Select * from records where inNumber='"+id+"'";
				java.sql.Statement st = c.createStatement();
				ResultSet set = st.executeQuery(q);
				
				if(!set.isBeforeFirst()) {
					//three wrong attempt
					
					out.print("<br><br><br><center><b>no records found</b></center>");
					RequestDispatcher rd = request.getRequestDispatcher("search.html");
					rd.include(request, response);
					System.out.println("invalid3");
				}else {
					out.print("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
							+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>"
							+ "<style> .table1{margin-left:5%;width:90%;margin-right:5%; margin-top:-15px;border='1px solid black';} .btn1{margin-left:5%;margin-bottom:2%;} </style>");
					
					out.print("<br><table class='table table1'><tr><th>IN Number</th>");
					
					out.print("<th>Concure ID</th>");
					out.print("<th>Title</th>");
					out.print("<th>First Name</th>");
					out.print("<th>Middle Name</th>");
					out.print("<th>Last Name</th>");
					
					out.print("<th>Approving Manager</th>");
					out.print("<th>WBS Code</th>");
					out.print("<th>Project Name</th>");
					out.print("<th>Billabilty</th>");
					out.print("<th>Booking/Cancelation Date</th>");
					out.print("<th>DOB</th>");
					out.print("<th>Email ID</th>");
					out.print("<th>Mobile Number</th>");
					out.print("<th>Designation</th>");
					out.print("<th>Gender</th>");
					out.print("<th>From</th>");
					out.print("<th>To</th>");
					out.print("<th>Onward Date</th>");
					out.print("<th>Return Date</th>");
					out.print("<th>Service Required</th>");
					out.print("<th>Airline</th>");
					out.print("<th>Flight Number</th>");
					out.print("<th>Flight Time</th>");
					out.print("<th>TripNumber</th>");
					out.print("<th>PNR</th>");
					out.print("<th>Service Code</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Hotel</th>");
					out.print("<th>Hotel Preferrence</th>");
					out.print("<th>Notes</th>");
					out.print("<th>Domestic/International</th>");
					out.print("<th>Preferred Seat</th>");
					out.print("<th>Preferred Class</th>");
					out.print("<th>Preferred Food</th>");
					out.print("<th>Car Type</th>");
					out.print("<th>Cancelation</th>");
					out.print("<th>Fare</th>");
					out.print("<th>CGST</th>");
					out.print("<th>SGST</th>");
					out.print("<th>Total</th>");
					out.print("<th>Comments</th></tr>");
					
					
					
					
					
					
					while(set.next()) {
						String inNumber = set.getString(1);
						String concurID = set.getString(2);
						String title = set.getString(3);
						String firstName = set.getString(4);
						String middleName = set.getString(5);
						String lastName = set.getString(6);
						String wbsCode = set.getString(7);
						String projectName = set.getString(8);
						String billable = set.getString(9);
						String bcd = set.getString(10);
						String dob = set.getString(11);
						String emailId = set.getString(12);
						String mobileNumber = set.getString(13);
						String designation = set.getString(14);
						String gender = set.getString(15);
						String from = set.getString(16);
						String to = set.getString(17);
						String onward = set.getString(18);
						String returnd = set.getString(19);
						String serviceRequired = set.getString(20);
						String airline = set.getString(21);
						String flightNumber = set.getString(22);
						String flightTiming = set.getString(23);
						String tripNumber = set.getString(24);
						String pnr = set.getString(25);
						String serviceCode = set.getString(26);
						String vendor = set.getString(27);
						String vendorId = set.getString(28);
						String hotel = set.getString(29);
						String Hotelpref = set.getString(30);
						String notes = set.getString(31);
						String domInt = set.getString(32);
						String pseat = set.getString(33);
						String pclass = set.getString(34);
						String pfood = set.getString(35);
						String carType = set.getString(36);
						String cancelation = set.getString(37);
						String fare = set.getString(38);
						String cgst = set.getString(39);
						String sgst = set.getString(40);
						String total = set.getString(41);
						String comment = set.getString(42);
						
						
					
						out.print("<tr><td>"+inNumber+"</td>");
						
						out.print("<td>"+concurID+"</td>");
						out.print("<td>"+title+"</td>");
						out.print("<td>"+firstName+"</td>");
						out.print("<td>"+middleName+"</td>");
						out.print("<td>"+lastName+"</td>");
						out.print("<td>"+wbsCode+"</td>");
						out.print("<td>"+projectName+"</td>");
						out.print("<td>"+billable+"</td>");
						out.print("<td>"+bcd+"</td>");
						out.print("<td>"+dob+"</td>");
						out.print("<td>"+emailId+"</td>");
						out.print("<td>"+mobileNumber+"</td>");
						out.print("<td>"+designation+"</td>");
						out.print("<td>"+gender+"</td>");
						out.print("<td>"+from+"</td>");
						out.print("<td>"+to+"</td>");
						out.print("<td>"+onward+"</td>");
						out.print("<td>"+returnd+"</td>");
						out.print("<td>"+serviceRequired+"</td>");
						out.print("<td>"+airline+"</td>");
						out.print("<td>"+flightNumber+"</td>");
						out.print("<td>"+flightTiming+"</td>");
						out.print("<td>"+tripNumber+"</td>");
						out.print("<td>"+pnr+"</td>");
						out.print("<td>"+serviceCode+"</td>");
						out.print("<td>"+vendor+"</td>");
						out.print("<td>"+vendorId+"</td>");
						out.print("<td>"+hotel+"</td>");
						out.print("<td>"+Hotelpref+"</td>");
						out.print("<td>"+notes+"</td>");
						out.print("<td>"+domInt+"</td>");
						out.print("<td>"+pseat+"</td>");
						out.print("<td>"+pclass+"</td>");
						out.print("<td>"+pfood+"</td>");
						out.print("<td>"+carType+"</td>");
						out.print("<td>"+cancelation+"</td>");
						out.print("<td>"+fare+"</td>");
						out.print("<td>"+cgst+"</td>");
						out.print("<td>"+sgst+"</td>");
						out.print("<td>"+total+"</td>");
						out.print("<td>"+comment+"</td>");
					}
				}	
				
			}else if(date.equals("") && id.equals("") && spokeName.equals("")) {
				q = "Select * from records where firstName='"+name+"'";
				java.sql.Statement st = c.createStatement();
				ResultSet set = st.executeQuery(q);
				
				if(!set.isBeforeFirst()) {
					//three wrong attempt
					
					out.print("<br><br><br><center><b>no records found</b></center>");
					RequestDispatcher rd = request.getRequestDispatcher("search.html");
					rd.include(request, response);
					System.out.println("invalid3");
				}else {
					out.print("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
							+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>"
							+ "<style> .table1{margin-left:5%;width:90%;margin-right:5%; margin-top:-15px;border='1px solid black';} .btn1{margin-left:5%;margin-bottom:2%;} </style>");
					
					out.print("<br><table class='table table1'><tr><th>IN Number</th>");
					
					out.print("<th>Concure ID</th>");
					out.print("<th>Title</th>");
					out.print("<th>First Name</th>");
					out.print("<th>Middle Name</th>");
					out.print("<th>Last Name</th>");
					
					out.print("<th>Approving Manager</th>");
					out.print("<th>WBS Code</th>");
					out.print("<th>Project Name</th>");
					out.print("<th>Billabilty</th>");
					out.print("<th>Booking/Cancelation Date</th>");
					out.print("<th>DOB</th>");
					out.print("<th>Email ID</th>");
					out.print("<th>Mobile Number</th>");
					out.print("<th>Designation</th>");
					out.print("<th>Gender</th>");
					out.print("<th>From</th>");
					out.print("<th>To</th>");
					out.print("<th>Onward Date</th>");
					out.print("<th>Return Date</th>");
					out.print("<th>Service Required</th>");
					out.print("<th>Airline</th>");
					out.print("<th>Flight Number</th>");
					out.print("<th>Flight Time</th>");
					out.print("<th>TripNumber</th>");
					out.print("<th>PNR</th>");
					out.print("<th>Service Code</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Hotel</th>");
					out.print("<th>Hotel Preferrence</th>");
					out.print("<th>Notes</th>");
					out.print("<th>Domestic/International</th>");
					out.print("<th>Preferred Seat</th>");
					out.print("<th>Preferred Class</th>");
					out.print("<th>Preferred Food</th>");
					out.print("<th>Car Type</th>");
					out.print("<th>Cancelation</th>");
					out.print("<th>Fare</th>");
					out.print("<th>CGST</th>");
					out.print("<th>SGST</th>");
					out.print("<th>Total</th>");
					out.print("<th>Comments</th></tr>");
					
					
					
					
					
					
					while(set.next()) {
						String inNumber = set.getString(1);
						String concurID = set.getString(2);
						String title = set.getString(3);
						String firstName = set.getString(4);
						String middleName = set.getString(5);
						String lastName = set.getString(6);
						String wbsCode = set.getString(7);
						String projectName = set.getString(8);
						String billable = set.getString(9);
						String bcd = set.getString(10);
						String dob = set.getString(11);
						String emailId = set.getString(12);
						String mobileNumber = set.getString(13);
						String designation = set.getString(14);
						String gender = set.getString(15);
						String from = set.getString(16);
						String to = set.getString(17);
						String onward = set.getString(18);
						String returnd = set.getString(19);
						String serviceRequired = set.getString(20);
						String airline = set.getString(21);
						String flightNumber = set.getString(22);
						String flightTiming = set.getString(23);
						String tripNumber = set.getString(24);
						String pnr = set.getString(25);
						String serviceCode = set.getString(26);
						String vendor = set.getString(27);
						String vendorId = set.getString(28);
						String hotel = set.getString(29);
						String Hotelpref = set.getString(30);
						String notes = set.getString(31);
						String domInt = set.getString(32);
						String pseat = set.getString(33);
						String pclass = set.getString(34);
						String pfood = set.getString(35);
						String carType = set.getString(36);
						String cancelation = set.getString(37);
						String fare = set.getString(38);
						String cgst = set.getString(39);
						String sgst = set.getString(40);
						String total = set.getString(41);
						String comment = set.getString(42);
						
						
					
						out.print("<tr><td>"+inNumber+"</td>");
						
						out.print("<td>"+concurID+"</td>");
						out.print("<td>"+title+"</td>");
						out.print("<td>"+firstName+"</td>");
						out.print("<td>"+middleName+"</td>");
						out.print("<td>"+lastName+"</td>");
						out.print("<td>"+wbsCode+"</td>");
						out.print("<td>"+projectName+"</td>");
						out.print("<td>"+billable+"</td>");
						out.print("<td>"+bcd+"</td>");
						out.print("<td>"+dob+"</td>");
						out.print("<td>"+emailId+"</td>");
						out.print("<td>"+mobileNumber+"</td>");
						out.print("<td>"+designation+"</td>");
						out.print("<td>"+gender+"</td>");
						out.print("<td>"+from+"</td>");
						out.print("<td>"+to+"</td>");
						out.print("<td>"+onward+"</td>");
						out.print("<td>"+returnd+"</td>");
						out.print("<td>"+serviceRequired+"</td>");
						out.print("<td>"+airline+"</td>");
						out.print("<td>"+flightNumber+"</td>");
						out.print("<td>"+flightTiming+"</td>");
						out.print("<td>"+tripNumber+"</td>");
						out.print("<td>"+pnr+"</td>");
						out.print("<td>"+serviceCode+"</td>");
						out.print("<td>"+vendor+"</td>");
						out.print("<td>"+vendorId+"</td>");
						out.print("<td>"+hotel+"</td>");
						out.print("<td>"+Hotelpref+"</td>");
						out.print("<td>"+notes+"</td>");
						out.print("<td>"+domInt+"</td>");
						out.print("<td>"+pseat+"</td>");
						out.print("<td>"+pclass+"</td>");
						out.print("<td>"+pfood+"</td>");
						out.print("<td>"+carType+"</td>");
						out.print("<td>"+cancelation+"</td>");
						out.print("<td>"+fare+"</td>");
						out.print("<td>"+cgst+"</td>");
						out.print("<td>"+sgst+"</td>");
						out.print("<td>"+total+"</td>");
						out.print("<td>"+comment+"</td>");
					}
				}		
				
			}else if(name.equals("") && id.equals("") && spokeName.equals("")) {
				q = "Select * from records where BookingCancellationDate='"+date+"'";
				java.sql.Statement st = c.createStatement();
				ResultSet set = st.executeQuery(q);
				
				if(!set.isBeforeFirst()) {
					//three wrong attempt
					
					out.print("<br><br><br><center><b>no records found</b></center>");
					RequestDispatcher rd = request.getRequestDispatcher("search.html");
					rd.include(request, response);
					System.out.println("invalid3");
				}else {
					out.print("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
							+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>"
							+ "<style> .table1{margin-left:5%;width:90%;margin-right:5%; margin-top:-15px;border='1px solid black';} .btn1{margin-left:5%;margin-bottom:2%;} </style>");
					
					out.print("<br><table class='table table1'><tr><th>IN Number</th>");
					
					out.print("<th>Concure ID</th>");
					out.print("<th>Title</th>");
					out.print("<th>First Name</th>");
					out.print("<th>Middle Name</th>");
					out.print("<th>Last Name</th>");
					
					out.print("<th>Approving Manager</th>");
					out.print("<th>WBS Code</th>");
					out.print("<th>Project Name</th>");
					out.print("<th>Billabilty</th>");
					out.print("<th>Booking/Cancelation Date</th>");
					out.print("<th>DOB</th>");
					out.print("<th>Email ID</th>");
					out.print("<th>Mobile Number</th>");
					out.print("<th>Designation</th>");
					out.print("<th>Gender</th>");
					out.print("<th>From</th>");
					out.print("<th>To</th>");
					out.print("<th>Onward Date</th>");
					out.print("<th>Return Date</th>");
					out.print("<th>Service Required</th>");
					out.print("<th>Airline</th>");
					out.print("<th>Flight Number</th>");
					out.print("<th>Flight Time</th>");
					out.print("<th>TripNumber</th>");
					out.print("<th>PNR</th>");
					out.print("<th>Service Code</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Hotel</th>");
					out.print("<th>Hotel Preferrence</th>");
					out.print("<th>Notes</th>");
					out.print("<th>Domestic/International</th>");
					out.print("<th>Preferred Seat</th>");
					out.print("<th>Preferred Class</th>");
					out.print("<th>Preferred Food</th>");
					out.print("<th>Car Type</th>");
					out.print("<th>Cancelation</th>");
					out.print("<th>Fare</th>");
					out.print("<th>CGST</th>");
					out.print("<th>SGST</th>");
					out.print("<th>Total</th>");
					out.print("<th>Comments</th></tr>");
					
					
					
					
					
					
					while(set.next()) {
						String inNumber = set.getString(1);
						String concurID = set.getString(2);
						String title = set.getString(3);
						String firstName = set.getString(4);
						String middleName = set.getString(5);
						String lastName = set.getString(6);
						String wbsCode = set.getString(7);
						String projectName = set.getString(8);
						String billable = set.getString(9);
						String bcd = set.getString(10);
						String dob = set.getString(11);
						String emailId = set.getString(12);
						String mobileNumber = set.getString(13);
						String designation = set.getString(14);
						String gender = set.getString(15);
						String from = set.getString(16);
						String to = set.getString(17);
						String onward = set.getString(18);
						String returnd = set.getString(19);
						String serviceRequired = set.getString(20);
						String airline = set.getString(21);
						String flightNumber = set.getString(22);
						String flightTiming = set.getString(23);
						String tripNumber = set.getString(24);
						String pnr = set.getString(25);
						String serviceCode = set.getString(26);
						String vendor = set.getString(27);
						String vendorId = set.getString(28);
						String hotel = set.getString(29);
						String Hotelpref = set.getString(30);
						String notes = set.getString(31);
						String domInt = set.getString(32);
						String pseat = set.getString(33);
						String pclass = set.getString(34);
						String pfood = set.getString(35);
						String carType = set.getString(36);
						String cancelation = set.getString(37);
						String fare = set.getString(38);
						String cgst = set.getString(39);
						String sgst = set.getString(40);
						String total = set.getString(41);
						String comment = set.getString(42);
						
						
					
						out.print("<tr><td>"+inNumber+"</td>");
						
						out.print("<td>"+concurID+"</td>");
						out.print("<td>"+title+"</td>");
						out.print("<td>"+firstName+"</td>");
						out.print("<td>"+middleName+"</td>");
						out.print("<td>"+lastName+"</td>");
						out.print("<td>"+wbsCode+"</td>");
						out.print("<td>"+projectName+"</td>");
						out.print("<td>"+billable+"</td>");
						out.print("<td>"+bcd+"</td>");
						out.print("<td>"+dob+"</td>");
						out.print("<td>"+emailId+"</td>");
						out.print("<td>"+mobileNumber+"</td>");
						out.print("<td>"+designation+"</td>");
						out.print("<td>"+gender+"</td>");
						out.print("<td>"+from+"</td>");
						out.print("<td>"+to+"</td>");
						out.print("<td>"+onward+"</td>");
						out.print("<td>"+returnd+"</td>");
						out.print("<td>"+serviceRequired+"</td>");
						out.print("<td>"+airline+"</td>");
						out.print("<td>"+flightNumber+"</td>");
						out.print("<td>"+flightTiming+"</td>");
						out.print("<td>"+tripNumber+"</td>");
						out.print("<td>"+pnr+"</td>");
						out.print("<td>"+serviceCode+"</td>");
						out.print("<td>"+vendor+"</td>");
						out.print("<td>"+vendorId+"</td>");
						out.print("<td>"+hotel+"</td>");
						out.print("<td>"+Hotelpref+"</td>");
						out.print("<td>"+notes+"</td>");
						out.print("<td>"+domInt+"</td>");
						out.print("<td>"+pseat+"</td>");
						out.print("<td>"+pclass+"</td>");
						out.print("<td>"+pfood+"</td>");
						out.print("<td>"+carType+"</td>");
						out.print("<td>"+cancelation+"</td>");
						out.print("<td>"+fare+"</td>");
						out.print("<td>"+cgst+"</td>");
						out.print("<td>"+sgst+"</td>");
						out.print("<td>"+total+"</td>");
						out.print("<td>"+comment+"</td>");
					}
					
				}
				
			}else if(name.equals("") && id.equals("") && date.equals("")) {
				q = "Select * from records where spoke='"+spokeName+"'";
				java.sql.Statement st = c.createStatement();
				ResultSet set = st.executeQuery(q);
				
				if(!set.isBeforeFirst()) {
					//three wrong attempt
					
					out.print("<br><br><br><center><b>no records found</b></center>");
					RequestDispatcher rd = request.getRequestDispatcher("search.html");
					rd.include(request, response);
					System.out.println("invalid3");
				}else {
					out.print("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
							+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>"
							+ "<style> .table1{margin-left:5%;width:90%;margin-right:5%; margin-top:-15px;border='1px solid black';} .btn1{margin-left:5%;margin-bottom:2%;} </style>");
					
					out.print("<br><table class='table table1'><tr><th>IN Number</th>");
					
					out.print("<th>Concure ID</th>");
					out.print("<th>Title</th>");
					out.print("<th>First Name</th>");
					out.print("<th>Middle Name</th>");
					out.print("<th>Last Name</th>");
					
					out.print("<th>Approving Manager</th>");
					out.print("<th>WBS Code</th>");
					out.print("<th>Project Name</th>");
					out.print("<th>Billabilty</th>");
					out.print("<th>Booking/Cancelation Date</th>");
					out.print("<th>DOB</th>");
					out.print("<th>Email ID</th>");
					out.print("<th>Mobile Number</th>");
					out.print("<th>Designation</th>");
					out.print("<th>Gender</th>");
					out.print("<th>From</th>");
					out.print("<th>To</th>");
					out.print("<th>Onward Date</th>");
					out.print("<th>Return Date</th>");
					out.print("<th>Service Required</th>");
					out.print("<th>Airline</th>");
					out.print("<th>Flight Number</th>");
					out.print("<th>Flight Time</th>");
					out.print("<th>TripNumber</th>");
					out.print("<th>PNR</th>");
					out.print("<th>Service Code</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Vendor</th>");
					out.print("<th>Hotel</th>");
					out.print("<th>Hotel Preferrence</th>");
					out.print("<th>Notes</th>");
					out.print("<th>Domestic/International</th>");
					out.print("<th>Preferred Seat</th>");
					out.print("<th>Preferred Class</th>");
					out.print("<th>Preferred Food</th>");
					out.print("<th>Car Type</th>");
					out.print("<th>Cancelation</th>");
					out.print("<th>Fare</th>");
					out.print("<th>CGST</th>");
					out.print("<th>SGST</th>");
					out.print("<th>Total</th>");
					out.print("<th>Comments</th></tr>");
					
					
					
					
					
					
					while(set.next()) {
						String inNumber = set.getString(1);
						String concurID = set.getString(2);
						String title = set.getString(3);
						String firstName = set.getString(4);
						String middleName = set.getString(5);
						String lastName = set.getString(6);
						String wbsCode = set.getString(7);
						String projectName = set.getString(8);
						String billable = set.getString(9);
						String bcd = set.getString(10);
						String dob = set.getString(11);
						String emailId = set.getString(12);
						String mobileNumber = set.getString(13);
						String designation = set.getString(14);
						String gender = set.getString(15);
						String from = set.getString(16);
						String to = set.getString(17);
						String onward = set.getString(18);
						String returnd = set.getString(19);
						String serviceRequired = set.getString(20);
						String airline = set.getString(21);
						String flightNumber = set.getString(22);
						String flightTiming = set.getString(23);
						String tripNumber = set.getString(24);
						String pnr = set.getString(25);
						String serviceCode = set.getString(26);
						String vendor = set.getString(27);
						String vendorId = set.getString(28);
						String hotel = set.getString(29);
						String Hotelpref = set.getString(30);
						String notes = set.getString(31);
						String domInt = set.getString(32);
						String pseat = set.getString(33);
						String pclass = set.getString(34);
						String pfood = set.getString(35);
						String carType = set.getString(36);
						String cancelation = set.getString(37);
						String fare = set.getString(38);
						String cgst = set.getString(39);
						String sgst = set.getString(40);
						String total = set.getString(41);
						String comment = set.getString(42);
						
						
					
						out.print("<tr><td>"+inNumber+"</td>");
						
						out.print("<td>"+concurID+"</td>");
						out.print("<td>"+title+"</td>");
						out.print("<td>"+firstName+"</td>");
						out.print("<td>"+middleName+"</td>");
						out.print("<td>"+lastName+"</td>");
						out.print("<td>"+wbsCode+"</td>");
						out.print("<td>"+projectName+"</td>");
						out.print("<td>"+billable+"</td>");
						out.print("<td>"+bcd+"</td>");
						out.print("<td>"+dob+"</td>");
						out.print("<td>"+emailId+"</td>");
						out.print("<td>"+mobileNumber+"</td>");
						out.print("<td>"+designation+"</td>");
						out.print("<td>"+gender+"</td>");
						out.print("<td>"+from+"</td>");
						out.print("<td>"+to+"</td>");
						out.print("<td>"+onward+"</td>");
						out.print("<td>"+returnd+"</td>");
						out.print("<td>"+serviceRequired+"</td>");
						out.print("<td>"+airline+"</td>");
						out.print("<td>"+flightNumber+"</td>");
						out.print("<td>"+flightTiming+"</td>");
						out.print("<td>"+tripNumber+"</td>");
						out.print("<td>"+pnr+"</td>");
						out.print("<td>"+serviceCode+"</td>");
						out.print("<td>"+vendor+"</td>");
						out.print("<td>"+vendorId+"</td>");
						out.print("<td>"+hotel+"</td>");
						out.print("<td>"+Hotelpref+"</td>");
						out.print("<td>"+notes+"</td>");
						out.print("<td>"+domInt+"</td>");
						out.print("<td>"+pseat+"</td>");
						out.print("<td>"+pclass+"</td>");
						out.print("<td>"+pfood+"</td>");
						out.print("<td>"+carType+"</td>");
						out.print("<td>"+cancelation+"</td>");
						out.print("<td>"+fare+"</td>");
						out.print("<td>"+cgst+"</td>");
						out.print("<td>"+sgst+"</td>");
						out.print("<td>"+total+"</td>");
						out.print("<td>"+comment+"</td>");
					}
					
				}
			}
			
			else {
				out.print("<center><h1>Refresh</h1></center>");
				RequestDispatcher rd = request.getRequestDispatcher("search.html");
				rd.forward(request, response);
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
