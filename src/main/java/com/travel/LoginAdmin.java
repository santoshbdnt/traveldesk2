package com.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/loginadmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdmin() {
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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			
			//query
			String q = "select firstName from admin where userId='"+id+"' and password='"+pw+"'";
			
			java.sql.Statement st = c.createStatement();
			
			ResultSet set = st.executeQuery(q);
			
			
			
			if(!set.isBeforeFirst()) {
				//three wrong attempt
				out.print("<center><b>invalid login crediatial</b></center>");
				
				RequestDispatcher rd = request.getRequestDispatcher("adminlogin.html");
				rd.include(request, response);
			}else {
				while(set.next()) {
					 String fname = set.getString(1);
					 HttpSession session = request.getSession();
					 session.setAttribute("name", fname);
					 session.setAttribute("fname", fname);
					 
					 out.print("<style>h1{color:white;}</style>");
							 out.print("<h1>Hi, "+fname+"</h1>");
						RequestDispatcher rd = request.getRequestDispatcher("AdminInterface.jsp");
						rd.include(request, response);
				}
			}
			
					
			}catch(Exception e) {
				e.printStackTrace();
			}
	}

}
