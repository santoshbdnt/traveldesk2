package com.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

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
 * Servlet implementation class AdminEmailVerify
 */
@WebServlet("/adminpasswordemailverify")
public class AdminEmailVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEmailVerify() {
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
		
		String email = request.getParameter("email");
		int otpvalue = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			String q = "select * from admin where emailId='"+email+"'";
			
			java.sql.Statement st = c.createStatement();
			ResultSet set = st.executeQuery(q);
			
			
			if(!set.isBeforeFirst()) {
				//three wrong attempt
				
				out.print("<br><br><br><center><b>Your Email is not register, for more deatils contact with admin</b></center>");
				
				
			}
			
			while(set.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				
				Random rand = new Random();
				otpvalue = rand.nextInt(1255650);
				String otps = String.valueOf(otpvalue);
				session.setAttribute("otp1", otps);

				String to = email;// change accordingly
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
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
					message.setSubject("Hello");
					message.setText("your OTP is: " + otpvalue);
					//send message
					Transport.send(message);
					System.out.println("message sent successfully");
					RequestDispatcher rd = request.getRequestDispatcher("otpadmin.html");
					rd.forward(request, response);
				}

				catch (MessagingException e) {
					System.out.println(e);
					throw new RuntimeException(e);
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
