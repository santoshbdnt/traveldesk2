package com.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateRecord
 */
@WebServlet("/createrecord")
public class CreateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRecord() {
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
		
		String inNumber = request.getParameter("inNumber");
		
		String concurId = request.getParameter("concurId");
		String title = request.getParameter("title");
		String firstName = request.getParameter("fname");
		String middleName = request.getParameter("mname");
		String lastName = request.getParameter("lname");
		String manager = request.getParameter("manager");
		String wbsCode = request.getParameter("wbsCode");
		String projectName = request.getParameter("projectName");
		String billable = request.getParameter("billable");	
		String bcDate = request.getParameter("bcDate");
		String dob = request.getParameter("dob");
		String emailId = request.getParameter("emailId");
		String mobileNumber = request.getParameter("mobileNumber");
		String designation = request.getParameter("designation");
		String gender = request.getParameter("gender");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String onwardDate = request.getParameter("onwardDate");
		String returnDate = request.getParameter("returnDate");
		String serviceRequired = request.getParameter("serviceRequired");
		String airline = request.getParameter("airline");
		String flightNumber = request.getParameter("flightNumber");
		String flightTime = request.getParameter("flightTime");
		String serviceCode = request.getParameter("serviceCode");
		String tripNumber = request.getParameter("tripNumber");
		String pnr = request.getParameter("pnr");
		String vendor = request.getParameter("vendor");
		String vendorId = request.getParameter("vendorID");
				String hotel = request.getParameter("hotel");
		String hpr = request.getParameter("hpr");
		String notes = request.getParameter("notes");
		String domInt = request.getParameter("domInt");
		String pSeat = request.getParameter("pSeat");
		String pClass = request.getParameter("pClass");
		String pFood = request.getParameter("pFood");
		String carType = request.getParameter("carType");
		String cancelation = request.getParameter("cancelation");
		String fare = request.getParameter("fare");
		String cgst = request.getParameter("cgst");
		String sgst = request.getParameter("sgst");
		String total = request.getParameter("total");
		String comments = request.getParameter("comments");
		
		HttpSession session = request.getSession();
	
		String spoke = (String) session.getAttribute("spokeName");
		String spokeEmail = (String) session.getAttribute("spokeEmail");
		System.out.println(spoke);
		if(spoke.equals("null")) {
			out.print("Your not a valid user please login!!!");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			 rd.include(request, response);
		}else {
		
		try {
			//create drivers
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Create connection
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			
					

		
			
			String q = "insert into records(inNumber,concureId,middlename,approvingMananger,wbsCode,projectName,Billable,BookingCancellationDate,DOB,emailID,mobileNumber,designation,gender,tfrom,tto,onwardDate,returnDate,serviceRequired,airline,flightNumber,flightTime,serviceCode,ftripNumber,fpnr,vendor,hotel,hotelPref,notes,domInt,pSeat,PClass,pFood,carType,cancelation,fare,cgst,sgst,total,comments,spoke,firstName,lastName,title,vendorId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst = c.prepareStatement(q);
			pst.setString(1,inNumber);
			pst.setString(2, concurId);
			pst.setString(3,middleName);
			pst.setString(4,manager);
			pst.setString(5,wbsCode);
			pst.setString(6,projectName);
			pst.setString(7,billable);
			pst.setString(8,bcDate);
			pst.setString(9,dob);
			pst.setString(10,emailId);
			pst.setString(11,mobileNumber);
			pst.setString(12,designation);
			pst.setString(13,gender);
			pst.setString(14,from);
			pst.setString(15,to);
			pst.setString(16,onwardDate);
			pst.setString(17,returnDate);
			pst.setString(18,serviceRequired);
			pst.setString(19,airline);
			pst.setString(20,flightNumber);
			pst.setString(21,flightTime);
			pst.setString(22,serviceCode);
			pst.setString(23,tripNumber);
			pst.setString(24,pnr);
			pst.setString(25,vendor);
			pst.setString(26,hotel);
			pst.setString(27,hpr);
			pst.setString(28,notes);
			pst.setString(29,domInt);
			pst.setString(30,pSeat);
			pst.setString(31,pClass);
			pst.setString(32,pFood);
			pst.setString(33,carType);
			pst.setString(34,cancelation);
			pst.setString(35,fare);
			pst.setString(36,cgst);
			pst.setString(37,sgst);
			pst.setString(38,total);
			pst.setString(39,comments);
			pst.setString(40,spoke);
			pst.setString(41,firstName);
			pst.setString(42,lastName);
			pst.setString(43,title);
			pst.setString(44,vendorId);
			
			pst.executeUpdate();
			if(flightTime.isEmpty()) {
				System.out.println("empty");
			}else if(flightTime.isBlank()){
				System.out.println("blank");
			}
			if(!flightTime.isEmpty()) {
				String b = flightTime.substring(0,2);
				
				int a = Integer.parseInt(b);
				System.out.println();
				if(gender.equals("Female") && (a>=22 || a<=7)) {
					// Get the session object
					Properties props = new Properties();
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.socketFactory.port", "465");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.port", "465");
					
					Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("testajemail@gmail.com", "hnztfhuxcmovwnzd");// Put your email
																											// id and
																											// password here
						}
					});
					
					// compose message
					try {
						MimeMessage message = new MimeMessage(session1);
						message.setFrom(new InternetAddress("testajemail@gmail.com"));// change accordingly
						 
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(spokeEmail));
						message.setSubject("Extra Cautious!");
						message.setContent("hi,"+spoke+"<br>Your create a record recently with INNumber :"+inNumber+" and traveler name is "+firstName+" "+middleName+" "+lastName+", her landing time is "+flightTime+", be cautious <br><br>Thanks and Regards,<br>Java Team.","text/html");
						// send message
						Transport.send(message);
						System.out.println("Message sent successfully");
						
						
					
						
					}

					catch (MessagingException e) {
						throw new RuntimeException(e);
					}
			}
			
			
				
			
		}
			out.print("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
					+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>");
			
			out.print("<center><h1>Your Form is successFully submitted.</h1>");
			out.print("<img src='images/success.png' width='250px' height='250px'>");
			out.print("<br><br><a href='employeeInterface.html'><button class='btn btn-primary'>Go Employee Interface</button></a>");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
		
		
		
		
		
		
	}
	
	

}
