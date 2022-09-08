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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String id = request.getParameter("id");
		
		String pw = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//setup  drivers
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
		
		//query
		String q = "select firstName,lastName,emailId from employees where userId='"+id+"' and password='"+pw+"'";
		
		java.sql.Statement st = c.createStatement();
		
		ResultSet set = st.executeQuery(q);
		
		
		
		if(!set.isBeforeFirst()) {
			//three wrong attempt
			out.print("<center><b>invalid login crediatial</b></center>");
			
			RequestDispatcher rd = request.getRequestDispatcher("employeelogin.html");
			rd.include(request, response);
		}else {
			while(set.next()) {
				 String fname = set.getString(1);
				 String lname = set.getString(2);
				 String emailId = set.getString(3);
				 String fullName = fname+" "+lname;
				 HttpSession session = request.getSession();
				 
				 session.setAttribute("spokeName", fullName);
				 session.setAttribute("spokeEmail", emailId);
				 
				 if(fname.equals("null") || fname.equals("") ) {
					 RequestDispatcher rd = request.getRequestDispatcher("employeeInterface.jsp");
					 rd.forward(request, response);
				 }
				 out.print("<style>h1{color:white;}</style>");
						 out.print("<h1>Hi, "+fname+"</h1>");
					RequestDispatcher rd = request.getRequestDispatcher("employeeInterface.html");
					rd.include(request, response);
			}
		}
		
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
