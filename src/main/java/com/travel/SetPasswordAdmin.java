package com.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SetPasswordAdmin
 */
@WebServlet("/setpasswordadmin")
public class SetPasswordAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPasswordAdmin() {
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
		
		HttpSession session = request.getSession();
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		String email  = (String) session.getAttribute("email");
		if(p1.equals(p2)) {
			System.out.println(email);
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			String q = "update admin set password='"+p1+"' where emailId='"+email+"'";
			Statement st = c.createStatement();
			st.executeUpdate(q);
			out.print("<h1>Your Password change successfully</h1>");
			out.print("<a href='index.html'>LogIn</a>");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			out.print("Something Went Wrong!");
		}
	}

}
