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

/**
 * Servlet implementation class CreateEmployee
 */
@WebServlet("/createemployee")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployee() {
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
		
		String userId = request.getParameter("userId");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phoneNumber = request.getParameter("phoneNumber");
		String doj = request.getParameter("doj");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String designation = request.getParameter("designation");
		String gender = request.getParameter("gnd1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			
			String q1 = "select * from employees where userId='"+userId+"'";
			java.sql.Statement st = c.createStatement();
			ResultSet set = st.executeQuery(q1);
			
			if(set.isBeforeFirst()) {
				//three wrong attempt
				
				out.print("<br><br><br><center><b>this id '"+userId+"' is already exists</b></center>");
				RequestDispatcher rd = request.getRequestDispatcher("createEmployee.html");
				rd.include(request, response);
				
			}
			
			
			String q = "insert into employees(userId,firstName,lastName,gender,Designation,emailId,phoneNumber,dob,doj,password) values(?,?,?,?,?,?,?,?,?,?)";
			
			
			
			PreparedStatement pst = c.prepareStatement(q);
			
			pst.setString(1, userId);
			pst.setString(2, fname);
			pst.setString(3, lname);
			pst.setString(4, gender);
			pst.setString(5, designation);
			pst.setString(6, email);
			pst.setString(7, phoneNumber);
			pst.setString(8, dob);
			pst.setString(9, doj);
			pst.setString(10, pw);
			
			pst.executeUpdate();
			
			Properties pr = new Properties();
			pr.put("mail.smtp.host", "smtp.gmail.com");
			pr.put("mail.smtp.socketFactory.port", "465");
			pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			pr.put("mail.smtp.auth", "true");
			pr.put("mail.smtp.port", "465");
			
			Session session = Session.getDefaultInstance(pr, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("testajemail@gmail.com", "hnztfhuxcmovwnzd");
				}
			});
			
			// compose message
						try {
							Message message = new MimeMessage(session);
							message.setFrom(new InternetAddress("testajemail@gmail.com"));// change accordingly
							message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
							message.setSubject("Congratuclation your account is created!");
							message.setContent("<b>Hi,"+fname+"</b><br><br><br> Conguratulation, Your Account is created<br>your user id : "+userId+"<br>Password :"+pw+".<br><br><b>Thanks & Regards<br>Abc Traveles Teams.</b>","text/html");
							Transport.send(message);
							System.out.println("message sent successfully");
							out.print("<h1>Your Form is SuccessFully Created and message successfully sent to the user</h1>");
						}

						catch (MessagingException e) {
							throw new RuntimeException(e);
						}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
