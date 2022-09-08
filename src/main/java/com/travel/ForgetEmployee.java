package com.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
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

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class ForgetEmployee
 */
@WebServlet("/forgetemployee")
public class ForgetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetEmployee() {
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
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			String q = "select firstName,emailId from employees where emailId ='"+email+"'";
			
			java.sql.Statement st = c.createStatement();
			ResultSet set = st.executeQuery(q);
			
			if(set.isBeforeFirst()) {
				int otpValue = 0;
				while(set.next()) {
					//generating otp
					Random rand = new Random();
					otpValue = rand.nextInt(1234567);
					
					//get session object setting google
					Properties pr = new Properties();
					pr.put("mail.smtp.host", "smtp.gmail.com");
					pr.put("mail.smtp.socketFactory.port", "465");
					pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					pr.put("mail.smtp.auth", "true");
					pr.put("mail.smtp.port", "465");
					
					//creating session
					Session session = Session.getDefaultInstance(pr,new javax.mail.Authenticator() {
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication("testajemail@gmail.com", "hnztfhuxcmovwnzd");
						}
					});
					
					// compose message
					try {
						MimeMessage message = new MimeMessage(session);
						message.setFrom(new InternetAddress("testajemail@gmail.com"));// change accordingly
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
						message.setSubject("Password recovery otp verifiication : ");
						message.setText("your OTP is: " + otpValue);
						// send message
						Transport.send(message);
						System.out.println(otpValue);
						System.out.println("message sent successfully");
						RequestDispatcher rd = request.getRequestDispatcher("otpEmployee.html");
						String sotp = String.valueOf(otpValue);
						HttpSession mySession = request.getSession();
						mySession.setAttribute("email", email);
						mySession.setAttribute("otp", sotp);
						rd.forward(request, response);
					}

					catch (MessagingException e) {
						throw new RuntimeException(e);
					}
					
				}
			}else {
				out.print("<h1>You are not register, please contact to the admin<h1>");
				
			}
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
