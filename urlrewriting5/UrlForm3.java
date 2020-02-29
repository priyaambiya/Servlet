package com.sessionmanagment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/next3")
public class UrlForm3 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	    String uname=req.getParameter("uname");
	    String password=req.getParameter("upass");
	    
	    pw.print("Servlet 3");
	    pw.println("<center>uname is= "+uname+"  upass is= "+password+"</center>");
		
	
		
	}

}
