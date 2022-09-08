package com.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class ViewEmployee
 */
@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEmployee() {
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
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelwebsite","root","Meer@9860");
			String q = "select * from employees";
			
			java.sql.Statement st = c.createStatement();
			ResultSet set = st.executeQuery(q);
			
			out.print("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
					+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>"
					+ "<style> .table1{margin-left:5%;width:90%;margin-right:5%; margin-top:-15px;border='1px solid black';} .btn1{margin-left:5%;margin-bottom:2%;} </style>");
			
			out.print("<br><br><table class='table table1'><tr><th>User ID</th>");
			out.print("<th>First Name</th>");
			out.print("<th>Last Name</th>");
			out.print("<th>Gender</th>");
			out.print("<th>Designation</th>");
			out.print("<th>Email ID</th>");
			out.print("<th>Phone Number</th>");
			out.print("<th>DOB</th>");
			out.print("<th>DOJ</th></tr>");
			
			
			
			while(set.next()) {
				
				String userId = set.getString(1);
				String firstName = set.getString(2);
				String lastName = set.getString(3);
				String gender = set.getString(4);
				String designation = set.getString(5);
				String emailId = set.getString(6);
				String phoneNumber = set.getString(7);
				String dob = set.getString(8);
				String doj = set.getString(9);
				
				out.print("<tr><td>"+userId+"</td>");
				out.print("<td>"+firstName+"</td>");
				out.print("<td>"+lastName+"</td>");
				out.print("<td>"+gender+"</td>");
				out.print("<td>"+designation+"</td>");
				out.print("<td>"+emailId+"</td>");
				out.print("<td>"+phoneNumber+"</td>");
				out.print("<td>"+dob+"</td>");
				out.print("<td>"+doj+"</td>");
				
				
			}
			out.print("</tr></table>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
