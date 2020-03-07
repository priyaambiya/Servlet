package com.registrationservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutController extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw=res.getWriter();
		HttpSession ses=req.getSession(false);
		if(ses!=null)
		{
			ses.invalidate();//jo session phle se bna hota h usko remove kr deta h
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req,res);
			pw.println("<center>successfully logout</center>");
			
			
			
		}
		else
		{
		        //jo session phle se bna hota h usko remove kr deta h
			RequestDispatcher rd=req.getRequestDispatcher("/login.html");
			rd.forward(req,res);
			pw.println("login first to access");
			
			
		}
		
		}
	
	

}
