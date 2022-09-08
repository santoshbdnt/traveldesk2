package com.travel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewPassword2
 */
@WebServlet("/newpassword2")
public class NewPassword2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPassword2() {
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
		String otp1 = request.getParameter("otp");
		HttpSession session = request.getSession();
		String otp2 = (String) session.getAttribute("otp1");
		String email = (String) session.getAttribute("email");
		System.out.println("otp enter :"+otp1);
		System.out.println("otp random :"+otp2);
		
		if(otp1.equals(otp2)) {
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("setpasswordadmin.html");
			rd.forward(request, response);
		}else {
			out.print("Enter Correct OTP :");
			RequestDispatcher rd = request.getRequestDispatcher("otpadmin.html");
			rd.include(request, response);
		}
	}

}
