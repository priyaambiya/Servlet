package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/homek")
public class HomeController extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	
		HttpSession ses=req.getSession(false);
		String user=(String) ses.getAttribute("user");
		if(ses!=null)
		{
		PrintWriter pw=res.getWriter();
		pw.println("<center><h3>welcome "+user+"</h3></center>");
		pw.println("<center><table><tr><td><a href='viewalluser'>View all user</a></td></tr>");
		pw.println("<tr><td><a href='viewuser'>View user Data</a></td></tr>");
		pw.println("<tr><td><a href='changepasswordk'>Change Password</a></td></tr>");
		pw.println("<tr><td><a href='logout'>Logout</a></td></tr></table></center>");
		}
		else
		{
			res.sendRedirect("login.html");
		}
	}

}
