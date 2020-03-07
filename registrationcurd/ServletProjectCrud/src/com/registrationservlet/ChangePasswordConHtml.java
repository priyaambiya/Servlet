package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/changepasswordk")
public class ChangePasswordConHtml  extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession sess=req.getSession(false);
		if(sess!=null)
		{
		String uname=(String)sess.getAttribute("user");
		
	
		PrintWriter pw=res.getWriter();
		pw.println("<center>Welcome "+uname+"</center>");
		pw.println("<center><h4>change password</h4></center>");

		pw.println("<center><table><form action='changee' method='post'>"
				+"<tr><td>Current password</td><td><input type='password' name='cpass'></td></tr>"
				+"<tr><td>New password</td><td><input type='password' name='npass'></td></tr>"
				+"<tr><td>Confirm password</td><td><input type='password' name='confirmpass'></td></tr>"
				+"<tr><td><input type='submit' value='change'></td></tr></table></center>");
		}
		else
		{
			res.sendRedirect("login.html");
		}	
		}

}
