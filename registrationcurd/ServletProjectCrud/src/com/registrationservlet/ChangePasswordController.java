package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/changee")
public class ChangePasswordController extends HttpServlet
{ @Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
{
	try
	{
		PrintWriter pw=res.getWriter();
		HttpSession ses=req.getSession(false);
		if(ses!=null)
		{
		String user= (String) ses.getAttribute("user");
		String pass=(String) ses.getAttribute("pass");
		String currentpass=  req.getParameter("cpass");
		String newpass=req.getParameter("npass");
		String confirmpass=req.getParameter("confirmpass");
		if(newpass.equals(confirmpass))
		{
			if(pass.equals(currentpass))
			{
				Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/piya","root","root");
			PreparedStatement ps=con.prepareStatement("update registration set password='"+newpass+"' where username='"+user+"' and password='"+pass+"'");
			 int row=ps.executeUpdate();
			 if(row>0)
			 {
				 RequestDispatcher rd= req.getRequestDispatcher("homek");
				 rd.include(req, res);
				 pw.println("<center>changepassward successfully</center>");
			 }
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("/changepassword.html"); 
				rd.include(req, res);
				pw.println("Current Password is not correct....Try Again!");
			}
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/changepassword.html"); 
			rd.include(req, res);
			pw.println("New Password and Confirm Password Doesn't match....Try Again!");
		}

		}	
	else
	{
	res.sendRedirect("login.html");	
	}
	}
	catch(Exception e)

	{
		e.printStackTrace();
	}

}

}
