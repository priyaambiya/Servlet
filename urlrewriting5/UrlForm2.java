package com.sessionmanagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/next2")
public class UrlForm2 extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	    String uname=req.getParameter("uname");
	    String password=req.getParameter("upass");
	    
	    pw.print("Servlet 2");
	    pw.print("<center><a href='next3?uname="+uname+"&upass="+password+"'>click here</a></center>");
		
	
		
	}

}
